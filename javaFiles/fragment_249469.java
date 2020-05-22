public class Frame extends JFrame {

    String[] list = {"Human", "Goat", "Dog", "Cat", "Duck"};
    ArrayList<JButton> button = new ArrayList<JButton>();
    JComboBox cBox = new JComboBox(list);
    JPanel container = new JPanel();
    JScrollPane scroller = new JScrollPane(container);

    public Frame() {
        cBox.addActionListener(new Action());
        this.setLayout(new BorderLayout());
        this.setSize(200, 200);
        this.add(cBox, BorderLayout.SOUTH);
        this.add(scroller, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);      
    }

    public void createBtn(String s) {
        System.out.println("Button's label : " + s);
        button.add(new JButton(s));
        System.out.println("Button's index : " + (button.size() - 1));
        container.add(button.get(button.size() - 1));

        //Note the new addition
        container.validate();
    }

    public class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action made");
            JComboBox temp = (JComboBox) e.getSource();
            createBtn(temp.getSelectedItem().toString());
        }
    }
}