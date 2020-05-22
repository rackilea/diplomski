import java.awt.event.ActionEvent;
import javax.swing.*;
import com.jidesoft.combobox.CheckBoxListComboBox;

public class TestCheckboxList extends JPanel{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                String[] items = {"Item1", "Item2", "Item3"};

                frame.add(new CheckBoxListComboBox(items){
                    @Override
                    protected Action getDialogOKAction() {
                        return new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("OK");
                            }
                        };
                    }

                    @Override
                    protected Action getDialogCancelAction() {
                        return new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Cancel");
                            }
                        };
                    }
                });

                frame.pack();

                frame.setVisible(true);
            }
        });
    }
}