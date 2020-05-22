import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.*;

public class ShowTextView implements MvcView {
   private JFrame frame = new JFrame();
   private JMenuBar menuBar = new JMenuBar();
   private JMenu fileMenu = new JMenu();
   private StatusBar statusBar = new StatusBar();
   private ViewDisplayText displayText = new ViewDisplayText();

   public ShowTextView(String title) {
      menuBar.add(fileMenu);

      frame.setTitle(title);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(displayText.getMainComponent(), BorderLayout.CENTER);
      frame.getContentPane().add(statusBar.getComponent(), BorderLayout.PAGE_END);
      frame.setJMenuBar(menuBar);
   }

   @Override
   public void setVisible(boolean visible) {
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   @Override
   public void setOpenFileAction(Action action) {
      displayText.setOpenFileButtonAction(action);
      fileMenu.add(new JMenuItem(action));
   }

   @Override
   public void setSaveToFileAction(Action action) {
      displayText.setSaveToFileAction(action);
      fileMenu.add(new JMenuItem(action));
   }

   @Override
   public void setExitAction(Action exitAction) {
      displayText.setExitAction(exitAction);
      fileMenu.add(new JMenuItem(exitAction));
   } 

   @Override
   public void setFileAction(Action fileAction) {
      fileMenu.setAction(fileAction);
   }


   @Override
   public String getTextAreaText() {
      return displayText.getTextAreaText();
   }

   @Override
   public void setTextAreaText(String text) {
      displayText.setTextAreaText(text);
   }

   @Override
   public Window getTopWindow() {
      return frame;
   }

   @Override
   public void setStatusText(String text) {
      statusBar.setText(text);
   }

}

class ViewDisplayText {
   private static final int TA_ROWS = 30;
   private static final int TA_COLS = 50;
   private static final int GAP = 2;
   private JPanel mainPanel = new JPanel();
   private JButton openFileButton = new JButton();
   private JButton saveToFileButton = new JButton();
   private JButton exitButton = new JButton();
   private JTextArea textArea = new JTextArea(TA_ROWS, TA_COLS);

   public ViewDisplayText() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
      buttonPanel.add(openFileButton);
      buttonPanel.add(saveToFileButton);
      buttonPanel.add(exitButton);

      mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
      mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
   }

   public void setExitAction(Action exitAction) {
      exitButton.setAction(exitAction);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void setOpenFileButtonAction(Action action) {
      openFileButton.setAction(action);
   }

   public void setSaveToFileAction(Action action) {
      saveToFileButton.setAction(action);
   }

   public String getTextAreaText() {
      return textArea.getText();
   }

   public void setTextAreaText(String text) {
      textArea.setText(text);
   }
}

class StatusBar {
   private static final String STATUS = "Status: ";
   private JLabel label = new JLabel(STATUS);

   public StatusBar() {
      label.setBorder(BorderFactory.createLineBorder(Color.black));
   }

   public JComponent getComponent() {
      return label;
   }

   public void setText(String text) {
      label.setText(STATUS + text);
   }
}