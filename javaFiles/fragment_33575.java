import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Test1 {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        String regex = "[a-z]";
        Pattern pt = Pattern.compile(regex);
        JFormattedTextField ft = new JFormattedTextField(pt);

        JTextField testField = new JTextField();
        ft.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {

                Matcher r = pt.matcher(ft.getText());
                if (!r.find()) {
                    testField.setText("not found");
                } else
                    testField.setText("found");
            }
        });
        frame.setLayout(new GridLayout(2, 1));
        frame.add(ft);
        frame.add(testField);
        frame.pack();
        frame.setVisible(true);
    }

}