import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;


public class JIntelligentComboBox extends JComboBox {

    private ArrayList<Object> itemBackup = new ArrayList<Object>();

    /**  Initisiert die JIntelligentComboBox */
    private void init(){

        class searchComboBoxEditor extends BasicComboBoxEditor {
            public searchComboBoxEditor(){
                super();
            }

            @Override
            public void setItem(Object anObject){
                if (anObject == null) {
                    super.setItem(anObject);
                } else {
                    Object[] o = (Object[]) anObject;
                    super.setItem(o[0]);
                }
            }

            @Override
            public Object getItem(){
                return new Object[]{super.getItem(), super.getItem(), 0};
            }
        }

        this.setEditor(new searchComboBoxEditor()); 

        this.setEditable(true); 

        class searchRenderer extends BasicComboBoxRenderer { 

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                if (index == 0) { 
                    setText(""); 
                    this.setPreferredSize(new Dimension(1, 1)); 
                    return this; 
                } 

                this.setPreferredSize(new Dimension(160, 17)); 

                if (index == list.getModel().getSize() - 1) { 
                    this.setBorder(new EmptyBorder(0, 3, 1, 3)); 
                } else { 
                    this.setBorder(new EmptyBorder(0, 3, 0, 3)); 
                }

                Object[] v = (Object[]) value; 
                //System.out.println(v[0]);
                this.setFont(new Font("Arial", Font.PLAIN, 12));
                this.setBackground(Color.white);

                String s = (String) v[0];
                String lowerS = s.toLowerCase();
                String sf = (String) v[1];
                String lowerSf = sf.toLowerCase();
                ArrayList<String> notMatching = new ArrayList<String>();

                if (!sf.equals("")){
                    int fs = -1;
                    int lastFs = 0;
                    while ((fs = lowerS.indexOf((String) lowerSf, (lastFs == 0) ? -1 : lastFs)) > -1) {
                        notMatching.add(s.substring(lastFs, fs));
                        lastFs = fs + sf.length();
                        //System.out.println(fs+sf.length());
                    }
                    notMatching.add(s.substring(lastFs));
                    //System.out.println(notMatching);
                }

                String html = "";

                if (notMatching.size() > 1) {
                    html = notMatching.get(0);
                    int start = html.length();
                    int sfl = sf.length();
                    for (int i = 1; i < notMatching.size(); i++) {
                        String t = notMatching.get(i);
                        html += "<b style=\"color: black;\">" + s.substring(start, start + sfl) + "</b>" + t;
                        start += sfl + t.length();
                    }
                }

                this.setText("<html><head></head><body style=\"color: gray;\">" + html + "</body></head>");
                return this;
            }

        }

        this.setRenderer(new searchRenderer());

        //
        int size = this.getModel().getSize();
        Object[] tmp = new Object[this.getModel().getSize()];

        for (int i = 0; i < size; i++) {
            tmp[i] = this.getModel().getElementAt(i);
            itemBackup.add(tmp[i]);
        }

        this.removeAllItems();

        this.getModel().addElement(new Object[]{"", "", 0});
        for (int i = 0; i < tmp.length; i++) {
            this.getModel().addElement(tmp[i]);
        }

        //
        this.getEditor().getEditorComponent().addKeyListener(new KeyListener() { 

            @Override 
            public void keyPressed(KeyEvent e) { 
                // TODO Auto-generated method stub 
            } 

            @Override 
            public void keyReleased(KeyEvent e) { 
                // TODO Auto-generated method stub 
                searchAndListEntries(((JTextField)JIntelligentComboBox.this.getEditor().getEditorComponent()).getText()); 
                //System.out.println(((JTextField)JIntelligentComboBox.this.getEditor().getEditorComponent()).getText()); 
            } 

            @Override 
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub 
            }
        });
    }

    public JIntelligentComboBox(){ 
        super(); 
    } 

    public JIntelligentComboBox(MutableComboBoxModel aModel){
        super(aModel); 
        init(); 
    } 

    public JIntelligentComboBox(Object[] items){
        super(items);
        init();
    }

    public JIntelligentComboBox(Vector<?> items){
        super(items);
        init();
    }

    @Override
    public MutableComboBoxModel getModel(){
        return (MutableComboBoxModel) super.getModel();
    }

    private void searchAndListEntries(Object searchFor){
        ArrayList<Object> found = new ArrayList<Object>();

        //System.out.println("sf: "+searchFor);

        for (int i = 0; i < this.itemBackup.size(); i++) {
            Object tmp = this.itemBackup.get(i);
            if (tmp == null || searchFor == null) continue;

            Object[] o = (Object[]) tmp;
            String s = (String) o[0];
            if (s.matches("(?i).*" + searchFor + ".*")){
                found.add(new Object[]{((Object[])tmp)[0], searchFor, ((Object[])tmp)[2]});
            }
        }

        this.removeAllItems();

        this.getModel().addElement(new Object[] {searchFor, searchFor, 0});

        for (int i = 0; i < found.size(); i++) {
            this.getModel().addElement(found.get(i));
        }

        //this.setPopupVisible(true);
        int size = this.getModel().getSize() - 1;

        System.out.println("Elements: " + size);

        if (size == 0)
        {
            this.setPopupVisible( false );
            return;
        }

        this.setPopupVisible(true);

        BasicComboPopup popup =
            (BasicComboPopup)this.getAccessibleContext().getAccessibleChild(0);
        Window popupWindow = SwingUtilities.windowForComponent(popup);
        Window comboWindow = SwingUtilities.windowForComponent(this);

        if (comboWindow.equals(popupWindow))
        {
            Component c = popup.getParent();
            Dimension d = c.getPreferredSize();
            c.setSize(d);
        }
        else
        {
            popupWindow.pack();
        }
    }
}