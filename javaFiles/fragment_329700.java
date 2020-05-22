import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import org.apache.log4j.Logger;

/**
 * Autocomplete combobox with filtering and text inserting of new text
 *
 * @author Exterminator13
 */
public class AutoCompleteCombo extends JComboBox
{
    private static final Logger logger = Logger.getLogger(AutoCompleteCombo.class);
    private Model model = new Model();
    private final JTextComponent textComponent = (JTextComponent) getEditor().getEditorComponent();
    private boolean modelFilling = false;
    private boolean updatePopup;

    public AutoCompleteCombo()
    {
        setEditable(true);
        setPattern(null);
        updatePopup = false;

        textComponent.setDocument(new AutoCompleteDocument());
        setModel(model);
        setSelectedItem(null);

        new Timer(20, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (updatePopup && isDisplayable())
                {
                    setPopupVisible(false);
                    if (model.getSize() > 0)
                    {
                        setPopupVisible(true);
                    }
                    updatePopup = false;
                }
            }
        }).start();
    }

    private class AutoCompleteDocument extends PlainDocument
    {
        boolean arrowKeyPressed = false;
        public AutoCompleteDocument()
        {
            textComponent.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_ENTER)
                    {
                        logger.debug("[key listener] enter key pressed");
                        //there is no such element in the model for now
                        String text = textComponent.getText();
                        if (!model.data.contains(text))
                        {
                            logger.debug("addToTop() called from keyPressed()");
                            addToTop(text);
                        }
                    }
                    else if (key == KeyEvent.VK_UP
                            || key == KeyEvent.VK_DOWN)
                    {
                        arrowKeyPressed = true;
                        logger.debug("arrow key pressed");
                    }
                }
            });
        }

        void updateModel() throws BadLocationException
        {
            String textToMatch = getText(0, getLength());
            logger.debug("setPattern() called from updateModel()");
            setPattern(textToMatch);
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException
        {
            if (modelFilling)
            {
                logger.debug("[remove] model is being filled now");
                return;
            }
            super.remove(offs, len);
            if (arrowKeyPressed)
            {
                arrowKeyPressed = false;
                logger.debug("[remove] arrow key was pressed, updateModel() was NOT called");
            }
            else
            {
                logger.debug("[remove] calling updateModel()");
                updateModel();
            }
            clearSelection();
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            if (modelFilling)
            {
                logger.debug("[insert] model is being filled now");
                return;
            }
            // insert the string into the document
            super.insertString(offs, str, a);

            String text = getText(0, getLength());
            if (arrowKeyPressed)
            {
                logger.debug("[insert] arrow key was pressed, updateModel() was NOT called");
                model.setSelectedItem(text);
                logger.debug(String.format("[insert] model.setSelectedItem(%s)", text));
                arrowKeyPressed = false;
            }
            else if (!text.equals(getSelectedItem()))
            {
                logger.debug("[insert] calling updateModel()");
                updateModel();
            }

            clearSelection();
        }
    }

    public void setText(String text)
    {
        if (model.data.contains(text))
        {
            setSelectedItem(text);
        }
        else
        {
            addToTop(text);
            setSelectedIndex(0);
        }
    }

    public String getText()
    {
        return getEditor().getItem().toString();
    }
    private String previousPattern = null;

    private void setPattern(String pattern)
    {

        if (pattern != null && pattern.trim().isEmpty())
        {
            pattern = null;
        }

        if (previousPattern == null && pattern == null
                || pattern != null && pattern.equals(previousPattern))
        {
            logger.debug("[setPatter] pattern is the same as previous: " + previousPattern);
            return;
        }
        previousPattern = pattern;
        modelFilling = true;
        model.setPattern(pattern);

        if (logger.isDebugEnabled())
        {
            StringBuilder b = new StringBuilder(100);
            b.append("pattern filter '").append(pattern == null ? "null" : pattern).append("' set:\n");
            for (int i = 0; i < model.getSize(); i++)
            {
                b.append(", ").append('[').append(model.getElementAt(i)).append(']');
            }
            int ind = b.indexOf(", ");
            if (ind != -1)
            {
                b.delete(ind, ind + 2);
            }
            logger.debug(b);
        }
        modelFilling = false;
        if (pattern != null)
        {
            updatePopup = true;
        }
    }

    private void clearSelection()
    {
        int i = getText().length();
        textComponent.setSelectionStart(i);
        textComponent.setSelectionEnd(i);
    }

    public synchronized void addToTop(String aString)
    {
        model.addToTop(aString);
    }

    private class Model extends AbstractListModel implements ComboBoxModel
    {
        String selected;
        final String delimiter = ";;;";
        final int limit = 20;

        class Data
        {
            private List<String> list = new ArrayList<String>(limit);
            private List<String> lowercase = new ArrayList<String>(limit);
            private List<String> filtered;

            void add(String s)
            {
                list.add(s);
                lowercase.add(s.toLowerCase());
            }

            void addToTop(String s)
            {
                list.add(0, s);
                lowercase.add(0, s.toLowerCase());
            }

            void remove(int index)
            {
                list.remove(index);
                lowercase.remove(index);
            }

            List<String> getList()
            {
                return list;
            }

            List<String> getFiltered()
            {
                if (filtered == null)
                {
                    filtered = list;
                }
                return filtered;
            }

            int size()
            {
                return list.size();
            }

            void setPattern(String pattern)
            {
                if (pattern == null || pattern.isEmpty())
                {
                    filtered = list;
                    AutoCompleteCombo.this.setSelectedItem(model.getElementAt(0));
                    logger.debug(String.format("[setPattern] combo.setSelectedItem(null)"));
                }
                else
                {
                    filtered = new ArrayList<String>(limit);
                    pattern = pattern.toLowerCase();
                    for (int i = 0; i < lowercase.size(); i++)
                    {
                        //case insensitive search
                        if (lowercase.get(i).contains(pattern))
                        {
                            filtered.add(list.get(i));
                        }
                    }
                    AutoCompleteCombo.this.setSelectedItem(pattern);
                    logger.debug(String.format("[setPattern] combo.setSelectedItem(%s)", pattern));
                }
                logger.debug(String.format("pattern:'%s', filtered: %s", pattern, filtered));
            }

            boolean contains(String s)
            {
                if (s == null || s.trim().isEmpty())
                {
                    return true;
                }
                s = s.toLowerCase();
                for (String item : lowercase)
                {
                    if (item.equals(s))
                    {
                        return true;
                    }
                }
                return false;
            }
        }
        Data data = new Data();

        void readData()
        {
            String[] countries =
            {
                "Afghanistan",
                "Albania",
                "Algeria",
                "Andorra",
                "Angola",
                "Argentina",
                "Armenia",
                "Austria",
                "Azerbaijan",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Belarus",
                "Belgium",
                "Benin",
                "Bhutan",
                "Bolivia",
                "Bosnia & Herzegovina",
                "Botswana",
                "Brazil",
                "Bulgaria",
                "Burkina Faso",
                "Burma",
                "Burundi",
                "Cambodia",
                "Cameroon",
                "Canada",
                "China",
                "Colombia",
                "Comoros",
                "Congo",
                "Croatia",
                "Cuba",
                "Cyprus",
                "Czech Republic",
                "Denmark",
                "Georgia",
                "Germany",
                "Ghana",
                "Great Britain",
                "Greece",
                "Somalia",
                "Spain",
                "Sri Lanka",
                "Sudan",
                "Suriname",
                "Swaziland",
                "Sweden",
                "Switzerland",
                "Syria",
                "Uganda",
                "Ukraine",
                "United Arab Emirates",
                "United Kingdom",
                "United States",
                "Uruguay",
                "Uzbekistan",
                "Vanuatu",
                "Venezuela",
                "Vietnam",
                "Yemen",
                "Zaire",
                "Zambia",
                "Zimbabwe"
            };

            for (String country : countries)
            {
                data.add(country);
            }
        }
        boolean isThreadStarted = false;

        void writeData()
        {
            StringBuilder b = new StringBuilder(limit * 60);

            for (String url : data.getList())
            {
                b.append(delimiter).append(url);
            }
            b.delete(0, delimiter.length());

            //waiting thread is already being run
            if (isThreadStarted)
            {
                return;
            }
            //we do saving in different thread
            //for optimization reasons (saving may take much time)
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    //we do sleep because saving operation
                    //may occur more than one per waiting period
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException ex)
                    {
                    }
                    //we need this synchronization to
                    //synchronize with AutoCompleteCombo.addElement method
                    //(race condition may occur)
                    synchronized (AutoCompleteCombo.this)
                    {

                        //HERE MUST BE SAVING OPERATION
                        //(SAVING INTO FILE OR SOMETHING)
                        //don't forget replace readData() method
                        //to read saved data when creating bean

                        isThreadStarted = false;
                    }
                }
            }).start();
            isThreadStarted = true;
        }

        public Model()
        {
            readData();
        }

        public void setPattern(String pattern)
        {
            int size1 = getSize();
            data.setPattern(pattern);
            int size2 = getSize();
            if (size1 < size2)
            {
                fireIntervalAdded(this, size1, size2 - 1);
                fireContentsChanged(this, 0, size1 - 1);
            }
            else if (size1 > size2)
            {
                fireIntervalRemoved(this, size2, size1 - 1);
                fireContentsChanged(this, 0, size2 - 1);
            }
        }

        public void addToTop(String aString)
        {
            if (aString == null || data.contains(aString))
            {
                return;
            }
            if (data.size() == 0)
            {
                data.add(aString);
            }
            else
            {
                data.addToTop(aString);
            }

            while (data.size() > limit)
            {
                int index = data.size() - 1;
                data.remove(index);
            }

            setPattern(null);
            model.setSelectedItem(aString);
            logger.debug(String.format("[addToTop] model.setSelectedItem(%s)", aString));

            //saving into options
            if (data.size() > 0)
            {
                writeData();
            }
        }

        @Override
        public Object getSelectedItem()
        {
            return selected;
        }

        @Override
        public void setSelectedItem(Object anObject)
        {
            if ((selected != null && !selected.equals(anObject))
                    || selected == null && anObject != null)
            {
                selected = (String) anObject;
                fireContentsChanged(this, -1, -1);
            }
        }

        @Override
        public int getSize()
        {
            return data.getFiltered().size();
        }

        @Override
        public Object getElementAt(int index)
        {
            return data.getFiltered().get(index);
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(3, 1));
                final JLabel label = new JLabel("label ");
                frame.add(label);
                final AutoCompleteCombo combo = new AutoCompleteCombo();
                frame.add(combo);
                frame.pack();
                frame.setSize(500, frame.getHeight());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}