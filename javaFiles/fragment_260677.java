class MyFrame {

    static CardLayout cl = new CardLayout(); //handles panel switching

    static JFrame frame; //init swing on EDT
    static FirstPanel firstPanel;
    static SecondPanel secondPanel;

    public static void main(String[] args) {
         initFrame();
    }

    public static void initFrame() {
         SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                   frame = new JFrame();
                   frame.setDefaultCloseOperation(3);
                   frame.setLayout(cl);

                   firstPanel = new FirstPanel();
                   secondPanel = new SecondPanel();


                   //first panel added to frame will always show first
                   frame.add(firstPanel, "first");
                   frame.add(secondPanel, "second");
                   frame.pack(); //sizes frame to fit the panel being shown

                   setVisible(true);
              }
         });
    }

    public static void switchPanel(String name) {
         cl.show(frame.getContentPane(), name);
         frame.pack();
    }
}   

class FirstPanel extends JPanel { }
class SecondPanel extends JPanel { }