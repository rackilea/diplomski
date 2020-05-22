import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class JRadioButtonExample extends JFrame   {

    static JCheckBox b[];
    static Vector<Boolean> check = new Vector<Boolean>();
    JButton altervista = new JButton("RUN");
    JButton selectall = new JButton("select all");
    JButton deselectall = new JButton("deselect all");
    static int num;

    private ArrayList<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

    public static JCheckBox[] getB() {
        return b;
    }

    public void setB(JCheckBox[] b2) {
        b = b2;
    }

    public Vector<Boolean> getCheck() {
        return check;
    }

    public void setCheck(Vector<Boolean> check2) {
        check = check2;
    }

    public JRadioButtonExample(int num, ArrayList<String> lbl) {

        super("JRadioButtonExample");

        getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));

        b = new JCheckBox[num];

        for (int i = 0; i < num; i++) {
            // creo i bottoni
            b[i] = new JCheckBox(lbl.get(i));
            getContentPane().add(b[i]);
        }

        // adding buttons
        getContentPane().add(selectall);
        getContentPane().add(deselectall);
        getContentPane().add(altervista);

        // adding listeners
        AscoltatoreSel asc1 = new AscoltatoreSel();
        selectall.addActionListener(asc1);
        setVisible(true);

        AscoltatoreDesel asc2 = new AscoltatoreDesel();
        deselectall.addActionListener(asc2);
        setVisible(true);

        Ascoltatore asc = new Ascoltatore();
        altervista.addActionListener(asc);
        setVisible(true);

        this.pack();
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.listeners.add(listener);
    }
    public void notifyObservers(){
        for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
            PropertyChangeListener name = (PropertyChangeListener) iterator
                    .next();
            name.propertyChange(null);

        }
    }

    class Ascoltatore extends WindowAdapter implements ActionListener {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == altervista) {
                setVisible(false);
                boh(b);
            }
            notifyObservers();
        }
    }

    class AscoltatoreSel extends WindowAdapter implements ActionListener {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == selectall) {
                for (int i = 0; i < num; i++) {
                    b[i].setSelected(true);
                    setVisible(true);
                }
            }
            notifyObservers();
        }
    }

    class AscoltatoreDesel extends WindowAdapter implements ActionListener {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == deselectall) {
                for (int i = 0; i < num; i++) {
                    b[i].setSelected(false);
                }
            }
            notifyObservers();
        }
    }

    public static void boh(JCheckBox[] b) {
        JCheckBox[] buttons = getB();

        for (JCheckBox c : buttons) {
            check.add(c.isSelected());
        }

    }
}