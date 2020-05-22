import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Solution extends JFrame {

private static final long serialVersionUID = 1L;
private JTabbedPane jtab;
private JScrollPane jsp;
private JTextArea jtxta;

public Solution() {
    jtab = new JTabbedPane();
    jtxta = new JTextArea();
    jsp = new JScrollPane(jtxta);
    jtab.addTab("[Untitle]", jsp);
    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    getContentPane().add(jtab, BorderLayout.CENTER);
    this.setSize(300,400);
    this.pack(); 
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    new Solution();
}
}