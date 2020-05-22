import java.awt.Dimension;
import java.util.*;
import javax.swing.*;

public class Test3 {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    list.add("Hello, World " + i);
                }
                JScrollPane pane = new JScrollPane(new JList(list.toArray())) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(200, 250);
                    }
                };
                JOptionPane.showMessageDialog(null, pane);
            }
        });
    }
}