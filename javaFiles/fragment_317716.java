import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.swing.*;
import javax.swing.text.*;

public class ElementEndOffsetTest {
  public JComponent makeUI() {
    String str = "name : andy\n"
               + "birth : jakarta, 1 jan 1990\n"
               + "number id : 01011990 01\n"
               + "age : 26\n"
               + "study : Informatics engineering\n";

    JTextArea textArea = new JTextArea(str);
    textArea.setEditable(false);
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(textArea));
    p.add(new JButton(new AbstractAction("add") {
      @Override public void actionPerformed(ActionEvent e) {
        Document doc = textArea.getDocument();
        Element root = doc.getDefaultRootElement();
        Optional.ofNullable(root.getElement(2)).ifPresent(el -> {
          try {
            doc.insertString(el.getEndOffset() - 1, " my text here", null);
          } catch (BadLocationException ex) {
            ex.printStackTrace();
          }
        });
      }
    }), BorderLayout.SOUTH);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ElementEndOffsetTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}