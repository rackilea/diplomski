import java.awt.event.*;


public class SOQ3
{
   JFrame mainWindowFrame;

   public static void main(String[] args)
   {

      SOQ3 s = new SOQ3();

   }

   public SOQ3()
   {

      initialize();

   }

   private void initialize()
   {
      mainWindowFrame = new JFrame();
      mainWindowFrame.setTitle("Lock and Log");
      mainWindowFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/lockandlog/main/resources/icon.png")));
      mainWindowFrame.setResizable(false);
      mainWindowFrame.setBounds(100, 100, 854, 480);
      mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainWindowFrame.getContentPane().setLayout(null);

      final JTextArea logDisplay = new JTextArea();
      logDisplay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
      logDisplay.setEditable(false);
      logDisplay.setBounds(259, 11, 579, 250);
      mainWindowFrame.getContentPane().add(logDisplay);

      JLabel viewCmdDisplayLbl = new JLabel("View Command Display:");
      viewCmdDisplayLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
      viewCmdDisplayLbl.setBounds(259, 272, 133, 14);
      mainWindowFrame.getContentPane().add(viewCmdDisplayLbl);

      JTextArea textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
      textArea.setBounds(259, 297, 579, 104);
      mainWindowFrame.getContentPane().add(textArea);

      JToolBar toolBar = new JToolBar();
      toolBar.setBounds(0, 412, 848, 16);
      mainWindowFrame.getContentPane().add(toolBar);

      JPanel manualGrp = new JPanel();
      manualGrp.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
      manualGrp.setBounds(10, 11, 239, 72);
      mainWindowFrame.getContentPane().add(manualGrp);
      manualGrp.setLayout(null);

      manualTxt = new JTextField();
      manualTxt.setBounds(10, 7, 219, 20);
      manualGrp.add(manualTxt);
      manualTxt.setColumns(10);

      JButton manualBtn = new JButton("Manual Override");
      manualBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
      manualBtn.setBounds(10, 38, 219, 23);
      manualGrp.add(manualBtn);

      JMenuBar menuBar = new JMenuBar();
      mainWindowFrame.setJMenuBar(menuBar);

      final JMenu fileBtn = new JMenu("File");
      fileBtn.addMouseListener(
            new MouseAdapter() //This works
            {
               @Override
               public void mouseEntered(MouseEvent e)
               {
                  fileBtn.setSelected(true);
               }
               @Override
               public void mouseExited(MouseEvent e)
               {
                  fileBtn.setSelected(false);
               }
            });
      menuBar.add(fileBtn);

      JMenuItem exitBtn = new JMenuItem("Exit");
      //Code is definitely passing through here.
      exitBtn.addActionListener(
            new ActionListener() //This doesn't work?
            {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                  logDisplay.setText("Test"); //This isn't even being called!
                  System.exit(0);
               }
            });
      //Definitely adds the button so code is passing through here.
      fileBtn.add(exitBtn);
   }

}