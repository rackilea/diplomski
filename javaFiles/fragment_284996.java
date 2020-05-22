import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Combo{

    JFrame frame;
    JComboBox cb;

    Combo() {
        frame = new JFrame("Combo ex");

        String country[] = {"India", "Aus", "U.S.A", "England", "Newzeland"};

        cb = new JComboBox(country);
        cb.setBounds(50, 50, 90, 20);
        cb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado=(String)cb.getSelectedItem();
                JOptionPane.showMessageDialog(frame, seleccionado);
            }
        });
        frame.add(cb);
        frame.setLayout(null);
        frame.setSize(400, 500);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Combo();

    }

}