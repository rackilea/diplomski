// This is a class, use the appropriate modifier.
     public class Slovnik() {
        // Field declarations should be made within the class, not outside of it.
        ArrayList<Slovo> slovoList;
        JFrame frame;
        private JTextField textOkno1;
        private JTextField preklad1;
        private JTextField spravne1;
        private JTextField textOkno2;
        private JTextField preklad2;
        private JTextField spravne2;

        private JButton btnNewButton_1;
        private JButton btnNewButton;

        ArrayList<Slovo> slovoList = new ArrayList<Slovo>();

        private class ActionListener1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(jetz.getPreklad());
            }
        }

        // Initialize your fields in the constructor.
        public Slovnik() {
            frame = new JFrame();
            frame.setBounds(100, 100, 544, 452);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            textOkno1 = new JTextField();
            textOkno1.setBounds(37, 11, 86, 20);
            frame.getContentPane().add(textOkno1);
            textOkno1.setColumns(10);

            JButton btnNewButton = new JButton("");
            btnNewButton.addActionListener(new ActionListener1());
            btnNewButton.setBounds(8, 362, 115, 41);
            frame.getContentPane().add(btnNewButton);
            preklad1 = new JTextField();
            preklad1.setBounds(163, 11, 86, 20);
            frame.getContentPane().add(preklad1);
            preklad1.setColumns(10);

            spravne1 = new JTextField();
            spravne1.setBounds(292, 11, 86, 20);
            frame.getContentPane().add(spravne1);
            spravne1.setColumns(10);

            textOkno2 = new JTextField();
            textOkno2.setBounds(37, 55, 86, 20);
            frame.getContentPane().add(textOkno2);
            textOkno2.setColumns(10);

            preklad2 = new JTextField();
            preklad2.setBounds(163, 55, 86, 20);
            frame.getContentPane().add(preklad2);
            preklad2.setColumns(10);

            spravne2 = new JTextField();
            spravne2.setBounds(292, 55, 86, 20);
            frame.getContentPane().add(spravne2);
            spravne2.setColumns(10);



            JButton btnNewButton_1 = new JButton("");

            btnNewButton_1.setBounds(163, 353, 131, 50);
            frame.getContentPane().add(btnNewButton_1);



            JButton btnNewButton_2 = new JButton("");
            btnNewButton_2.setBounds(318, 353, 200, 50);
            frame.getContentPane().add(btnNewButton_2);

            Slovo wien = new Slovo("vieden", "wien");
            slovoList.add(wien);
            Slovo hunt = new Slovo("pes", "hunt");
            slovoList.add(hunt);
            Slovo junge = new Slovo("chlapec", "junge");
            slovoList.add(junge);
            Slovo jetz = new Slovo("teraz", "jetz");
            Collections.shuffle(slovoList);
        }

        public static void main(String[] args) {    
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Slovnik window = new Slovnik();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });   
        }            
    }