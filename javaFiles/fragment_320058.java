import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JTextFieldFun {
    private static String sep = System.getProperty("line.separator");

    public void save(String filename, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3) {
        String id = jTextField1.getText();
        String name = jTextField2.getText();
        String last = jTextField3.getText();
        if (id.isEmpty() || name.isEmpty() || last.isEmpty()) {
            System.out.println("Empty text fields");
        } else {
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.write(sep + id + sep + name + sep + last);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void load(String filename, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            jTextField1.setText(reader.readLine());
            jTextField2.setText(reader.readLine());
            jTextField3.setText(reader.readLine());
        }
    }
}