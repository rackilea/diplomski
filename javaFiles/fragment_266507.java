import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * https://stackoverflow.com/questions/30288947
 * /accessing-jcombobox-data-from-separate-jform
 * 
 * @author Pete
 *
 */
public class SimpleMultPanels {
    private static void createAndShowGui() {
        // create JFrame
        JFrame frame = new JFrame("SimpleMultPanels");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // add our MainPanel to the JFrame
        frame.getContentPane().add(new MainPanel());
        frame.pack(); // pack it
        frame.setLocationByPlatform(true);
        frame.setVisible(true); // show it
    }

    public static void main(String[] args) {
        // this is for starting our Swing app on the event thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class MainPanel extends JPanel {
    private static final KeyStroke EXIT_KEY_STROKE = KeyStroke.getKeyStroke(
            KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);;

    private CardLayout cardLayout = new CardLayout();

    // the three "card" JPanels that this JPanel displays:
    private MenuPanel menuPanel = new MenuPanel();
    private HoldsComboBoxPanel holdsComboBoxPanel = new HoldsComboBoxPanel();
    private ShowSelectionPanel showSelectionPanel = new ShowSelectionPanel();

    // Actions for our JButtons
    private ExitAction exitAction = new ExitAction();
    private ShowAction backToMenuAction = new ShowAction(this, "Back to Menu",
            MenuPanel.NAME, KeyEvent.VK_B);
    private ShowAction toHoldsComboAction = new ShowAction(this, "Combo Panel",
            HoldsComboBoxPanel.NAME, KeyEvent.VK_C);
    private ShowAction toShowSelectionAction = new ShowAction(this,
            "Show Selection", ShowSelectionPanel.NAME, KeyEvent.VK_S);

    public MainPanel() {
        // add an ActionListener to the JComboBox
        holdsComboBoxPanel.addComboBoxListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get the combo's selected String
                String selection = holdsComboBoxPanel.getComboSelection();
                if (selection != null) {
                    // push it into showSelection
                    showSelectionPanel.setDisplayText(selection);
                }
            }
        });

        // add Actions to class to allow swapping of cards and
        holdsComboBoxPanel.addButtonAction(backToMenuAction);
        holdsComboBoxPanel.addButtonAction(toShowSelectionAction);
        holdsComboBoxPanel.addButtonAction(exitAction); // and to exit gui

        showSelectionPanel.addButtonAction(backToMenuAction);
        showSelectionPanel.addButtonAction(toHoldsComboAction);
        showSelectionPanel.addButtonAction(exitAction);

        menuPanel.addButtonAction(toHoldsComboAction);
        menuPanel.addButtonAction(toShowSelectionAction);
        menuPanel.addButtonAction(exitAction);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // set our layout
        setLayout(cardLayout);

        // and add our "card" JPanels
        add(menuPanel, MenuPanel.NAME);
        add(holdsComboBoxPanel, HoldsComboBoxPanel.NAME);
        add(showSelectionPanel, ShowSelectionPanel.NAME);

        setExitOnKeyStroke(EXIT_KEY_STROKE); // added 9/27/15
    }

    private void setExitOnKeyStroke(KeyStroke keyStroke) {
        // do your key bindings

        // first get ActionMap and InputMap
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        // then the keystroke
        String key = keyStroke.toString();

        inputMap.put(keyStroke, key); // map the keystroke to a String key
        actionMap.put(key, exitAction); // map the same String key to the Action
    }

    // method that allows outside classes to swap views
    public void showCard(String key) {
        cardLayout.show(this, key);
    }
}

@SuppressWarnings("serial")
class HoldsComboBoxPanel extends JPanel {
    // constant String that will be used by the CardLayout
    public static final String NAME = "holds combobox panel";

    // sample data
    private static final String[] DATA = { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday" };
    private JComboBox<String> comboBox = new JComboBox<>(DATA);

    // JPanel to hold buttons to allow moving between cards
    private JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));

    public HoldsComboBoxPanel() {
        comboBox.setSelectedIndex(-1);
        JPanel centerPanel = new JPanel();
        centerPanel.add(comboBox);

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // method to add a listener
    public void addComboBoxListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }

    // getter method
    public String getComboSelection() {
        return (String) comboBox.getSelectedItem();
    }

    // create a new JButton with an Action and add to buttonPanel
    public void addButtonAction(Action action) {
        buttonPanel.add(new JButton(action));
    }
}

@SuppressWarnings("serial")
class ShowSelectionPanel extends JPanel {
    public static final String NAME = "show selection panel";
    private static final int PREF_W = 300;
    private static final int PREF_H = PREF_W;
    private JTextField displayField = new JTextField(10);
    private JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));

    public ShowSelectionPanel() {
        displayField.setFocusable(false);

        JPanel centerPanel = new JPanel();
        centerPanel.add(displayField);

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // code to make our GUI a little larger
    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    // setter method
    public void setDisplayText(String text) {
        displayField.setText(text);
        // or do whatever else you want to do with the selection
    }

    public void addButtonAction(Action action) {
        buttonPanel.add(new JButton(action));
    }

}

@SuppressWarnings("serial")
class MenuPanel extends JPanel {
    public static final String NAME = "menu panel";
    private JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 5));

    public MenuPanel() {
        setLayout(new GridBagLayout());
        add(buttonPanel);
    }

    public void addButtonAction(Action action) {
        buttonPanel.add(new JButton(action));
    }
}

@SuppressWarnings("serial")
class ShowAction extends AbstractAction {
    private MainPanel mainPanel;
    private String key;

    /**
     * Abstract Action used by JButtons
     * 
     * @param mainPanel
     *            : the JPanel that uses the CardLayout
     * @param name
     *            : The name displayed by the button
     * @param key
     *            : The key used in the CardLayout#show(String key) mehtod
     * @param mnemonic
     *            : the JButton's mnemonic char
     */
    public ShowAction(MainPanel mainPanel, String name, String key, int mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
        this.mainPanel = mainPanel;
        this.key = key;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // tell the mainPanel to show the card associated with the key
        mainPanel.showCard(key);
    }
}

// class of mine to allow disposing of a window
// It's a little complex to allow it to work with either a JButton
// or a JMenuItem
@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
    public ExitAction() {
        super("Exit");
        putValue(MNEMONIC_KEY, KeyEvent.VK_X);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the button that caused this action
        Object source = e.getSource();
        Window topWindow = null;
        if (source instanceof AbstractButton) {
            AbstractButton exitButton = (AbstractButton) source;

            // get the parent top level window
            topWindow = SwingUtilities.getWindowAncestor(exitButton);
            if (topWindow == null) { // if null, then likely in a JMenuItem
                // so we have to get its jpopupmenu parent
                Container parent = exitButton.getParent();
                if (parent instanceof JPopupMenu) {
                    JPopupMenu popupMenu = (JPopupMenu) parent;

                    // get the invoker for the pop up menu
                    Component invoker = popupMenu.getInvoker();
                    if (invoker != null) {
                        // and get *its* top level window
                        topWindow = SwingUtilities.getWindowAncestor(invoker);
                    }
                }
            }
        } else if (source instanceof Component) {
            // if in key bindings
            topWindow = SwingUtilities.getWindowAncestor((Component) source);
        }
        if (topWindow != null) {
            // dispose of the top-level window
            topWindow.dispose();
        }
    }
}