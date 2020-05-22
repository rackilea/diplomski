public class MyFrame extends JFrame {
    private JButton jbt = new JButton("Open Window");
    private AnotherFrame jfrm = new AnotherFrame();

    public MyFrame(){
        add(jbt);
        jfrm.setVisibility(false);
        add(jfrm);

        jbt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jfrm.setVisibility(true);
            }
        });
    }

    private AnotherFrame extends JFrame {

        public AnotherFrame(){

       }

    }
}