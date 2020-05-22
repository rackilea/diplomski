import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;

public class SSCCE extends JFrame implements ActionListener, UndoableEditListener {
  private final JLabel labTextArea;
  private final JTextArea textArea;
  private final JScrollPane scrollTextArea;
  private final Document docTextArea;
  private final JButton bOne, bTwo, bUndo;
  private final UndoManager uOne, uTwo;
  private Document dOne, dTwo;

  public SSCCE(String[] args) {
    setTitle("SSCCE - Short, Self Contained, Correct Example");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 200);
    setLocationRelativeTo(null);

    labTextArea = new JLabel("One");
    getContentPane().add(labTextArea, BorderLayout.PAGE_START);

    uOne = new UndoManager();
    uTwo = new UndoManager();
    dOne = new PlainDocument();
    dTwo = new PlainDocument();
    dOne.addUndoableEditListener(this);
    dTwo.addUndoableEditListener(this);

    textArea = new JTextArea();
    docTextArea = textArea.getDocument();
    docTextArea.addUndoableEditListener(this);
    textArea.setDocument(dOne);
    scrollTextArea = new JScrollPane(textArea);
    getContentPane().add(scrollTextArea, BorderLayout.CENTER);

    JPanel pButtons = new JPanel();
    bOne = new JButton("One");
    bOne.addActionListener(this);
    bOne.setFocusable(false);
    pButtons.add(bOne, BorderLayout.LINE_START);
    bTwo = new JButton("Two");
    bTwo.addActionListener(this);
    bTwo.setFocusable(false);
    pButtons.add(bTwo, BorderLayout.LINE_END);
    bUndo = new JButton("Undo");
    bUndo.addActionListener(this);
    bUndo.setFocusable(false);
    pButtons.add(bUndo, BorderLayout.LINE_END);
    getContentPane().add(pButtons, BorderLayout.PAGE_END);

    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(bOne)) {
      if (!labTextArea.getText().equals("One")) {
        textArea.setDocument(dOne);
        labTextArea.setText("One");
      }
    }
    else if (e.getSource().equals(bTwo)) {
      if (!labTextArea.getText().equals("Two")) {
        textArea.setDocument(dTwo);
        labTextArea.setText("Two");
      }
    }
    else if (e.getSource().equals(bUndo)) {
      if (labTextArea.getText().equals("One")) {
        try {
          if (uOne.canUndo()) {
            System.out.println("Performing Undo for One");
            uOne.undo();
            System.out.println("Buffer One is now:\n" + textArea.getText() + "\n");
          }
          else {
            System.out.println("Nothing to Undo for One");
          }
        }
        catch (CannotUndoException ex) {
          ex.printStackTrace();
        }
      }
      else if (labTextArea.getText().equals("Two")) {
        try {
          if (uTwo.canUndo()) {
            System.out.println("Performing Undo for Two");
            uTwo.undo();
            System.out.println("Buffer Two is now:\n" + textArea.getText() + "\n");
          }
          else {
            System.out.println("Nothing to Undo for Two");
          }
        }
        catch (CannotUndoException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  @Override
  public void undoableEditHappened(UndoableEditEvent e) {
    if (labTextArea.getText().equals("One")) {
      System.out.println("Adding Edit for One");
      uOne.addEdit(e.getEdit());
    }
    else if (labTextArea.getText().equals("Two")) {
      System.out.println("Adding Edit for Two");
      uTwo.addEdit(e.getEdit());
    }
  }

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new SSCCE(args);
      }
    });
  }
}