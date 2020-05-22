public class Game extends JFrame {
    JTextArea jta = new JTextArea(10, 30);
    JTextField jtf = new JTextField(30);

    public Game(){
        add(jtf, BorderLayout.SOUTH);
        add(jta, BorderLayour.CENTER);

        jta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new Game();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}