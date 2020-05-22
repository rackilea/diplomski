public static void main(String[] args){


    TestPanel panel = new TestPanel();

    JButton button = new JButton();
    ActionListener al = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
         panel.change();
        }

    };

    button.addActionListener(al);

    JFrame frame = new JFrame();

    frame.add(panel);
    frame.add(button);

    frame.setVisible(true);
    frame.setLayout(new GridLayout(2, 1));
    frame.setSize(420, 360);



    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



}