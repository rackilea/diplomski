import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestFrame extends JFrame {

    public TestFrame(){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                init();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack();
                setVisible(true);
            }
        });
    }

    private void init() {
        final JComboBox<String> box = new JComboBox<String>(new String[]{"1","2"});
        final JTextField f = new JTextField(5);
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    f.setVisible("1".equals(box.getSelectedItem()));
                    TestFrame.this.revalidate();
                    TestFrame.this.repaint();
                }
            }
        });

        add(box,BorderLayout.SOUTH);
        add(f,BorderLayout.NORTH);
    }

    public static void main(String... s){
        new TestFrame();
    }

}