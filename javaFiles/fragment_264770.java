import javax.swing.*;

public class TrimSpace {

    TrimSpace() {
        String s = JOptionPane.showInputDialog(null, 
                "Name, Age, City", 
                "Person Details", 
                JOptionPane.QUESTION_MESSAGE);
        // show the raw string entered by user
        System.out.println(String.format("'%1s'", s));
        // remove leading & trailing space from string
        System.out.println(String.format("'%1s'", s.trim()));
        // remove all spaces from string
        System.out.println(String.format("'%1s'", s.replaceAll(" ", "")));
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new TrimSpace();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}