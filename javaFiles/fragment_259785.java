import java.awt.*;
import javax.swing.*;

class ManyButtons {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                NameClassifier nameClassifier = new NameClassifier();
                JScrollPane scrollPane = new JScrollPane(nameClassifier);
                scrollPane.setVerticalScrollBarPolicy(
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                frame.add(scrollPane);
                // nameClassifier has already been added to the scroll pane.
                //frame.getContentPane().add(nameClassifier);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                System.out.println("exiting");
            }
        });
    }
}

class NameClassifier extends JPanel {

    NameClassifier() {
        super(new GridLayout(0,10,2,2));
        for (int ii=1; ii<=1000; ii++) {
            add(new JButton("Button " + ii));
        }
    }
}