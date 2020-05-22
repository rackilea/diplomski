import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Database2 extends JPanel {
   // constants for the cards
   public static final String WELCOME = "welcome";
   public static final String ADD_STUDENT = "add student";
   public static final String DISPLAY_DATA = "display data";

   private JTextArea displayTextArea = new JTextArea(15, 20);
   private JTextField addStudentField = new JTextField(10);
   private CardLayout cardLayout = new CardLayout();
   private List<String> db = new ArrayList<>();

   public Database2() {
      // prepare JTextArea
      displayTextArea.setWrapStyleWord(true);
      displayTextArea.setLineWrap(true);
      displayTextArea.setFocusable(false);

      // set layout as CardLayout and add all JPanels with constants
      setLayout(cardLayout);
      add(createWelcomePanel(), WELCOME);
      add(createAddStudentPanel(), ADD_STUDENT);
      add(createDisplayDataPanel(), DISPLAY_DATA);
   }

   private JPanel createWelcomePanel() {
      ShowStudentPanelAction showStudentAction = new ShowStudentPanelAction("Add Student");
      DisplayDataAction displayDataAction = new DisplayDataAction("Display Data");
      JButton addStudentButton = new JButton(showStudentAction);
      JButton displayDataButton = new JButton(displayDataAction);

      JPanel topPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      topPanel.add(addStudentButton);
      topPanel.add(displayDataButton);
      topPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));

      JLabel welcomeLabel = new JLabel("Welcome", SwingConstants.CENTER);
      // make JLabel text bigger
      welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(Font.BOLD, 42f));

      // and give it a border 30 points wide
      int ebGap = 30;
      welcomeLabel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap,
            ebGap, ebGap));

      JPanel welcomePanel = new JPanel(new BorderLayout());
      ebGap = 4;
      welcomePanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
      welcomePanel.add(topPanel, BorderLayout.PAGE_START);
      welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

      return welcomePanel;
   }

   private JPanel createAddStudentPanel() {
      AddStudentAction addStudentAction = new AddStudentAction("Add Student");
      addStudentField.setAction(addStudentAction);
      JPanel addStudentPanel = new JPanel();
      addStudentPanel.add(addStudentField);
      addStudentPanel.add(new JButton(addStudentAction)); 
      return addStudentPanel;
   }

   private JPanel createDisplayDataPanel() {
      JPanel displayDataPanel = new JPanel();
      JScrollPane scrollPane = new JScrollPane(displayTextArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      displayDataPanel.add(scrollPane);
      displayDataPanel.add(new JButton(new ReturnToWelcomeAction("Return")));
      return displayDataPanel;
   }

   private class ShowStudentPanelAction extends AbstractAction {
      public ShowStudentPanelAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardLayout.show(Database2.this, ADD_STUDENT);
         addStudentField.requestFocusInWindow();
         addStudentField.selectAll();
      }
   }

   private class DisplayDataAction extends AbstractAction {
      public DisplayDataAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         StringBuilder sb = new StringBuilder();
         for (String studentName : db) {
            sb.append(studentName + "\n");
         }
         displayTextArea.setText(sb.toString());
         cardLayout.show(Database2.this, DISPLAY_DATA);
      }
   }

   private class AddStudentAction extends AbstractAction {
      public AddStudentAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String studentText = addStudentField.getText();
         db.add(studentText);
         cardLayout.show(Database2.this, WELCOME);
      }
   }

   private class ReturnToWelcomeAction extends AbstractAction {
      public ReturnToWelcomeAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardLayout.show(Database2.this, WELCOME);
      }
   }

   private class ExitAction extends AbstractAction {
      public ExitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Window window = SwingUtilities.getWindowAncestor(Database2.this);
         if (window != null) {
            window.dispose();
         }
      }
   }

   private static void createAndShowGui() {
      Database2 mainPanel = new Database2();

      JFrame frame = new JFrame("Database2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}