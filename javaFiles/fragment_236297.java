import java.awt.BorderLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.*;

    public class MyFrame extends JFrame{

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public MyFrame(){
            MainPanel panel = new MainPanel();
            add(panel,BorderLayout.CENTER);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            pack();
            panel.setVisible(true);
        }

        class MainPanel extends JPanel{

            /**
             * 
             */
            private static final long serialVersionUID = 1L;
            public MainPanel(){
                JButton button = new JButton("I am a button");
                add(button);
                button.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        // TODO Auto-generated method stub
                        System.out.println("JButton is clicked...");
                    }
                });
            }
        }

        public static void main(String args[]){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    MyFrame myFrame = new MyFrame();
                    myFrame.setVisible(true);
                }
            };
            SwingUtilities.invokeLater(runnable);
        }
    }