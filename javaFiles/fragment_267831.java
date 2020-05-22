public class LayoutTesting extends JFrame{
    Container pane;

    //Add card when button is pressed:
    public void addCard(){
        Container card = new JPanel();
        card.setBackground(Color.red);
        JButton newButton = addNewButton();
        newButton.setBackground(Color.red);
        card.add(newButton);
        pane.add(card);
        revalidate();
        repaint();
    }

    //Setup window and add button:
    public LayoutTesting(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        setLayout(new FlowLayout());
        pane = new JPanel();
        pane.setLayout(new GridBagLayout());
        JButton firstButton = addNewButton();
        firstButton.setBackground(Color.green);
        add(pane);
        add(firstButton);   
    }

    //Create button and action listener:
    public JButton addNewButton(){
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(40, 58));
        button.addActionListener(new java.awt.event.ActionListener(){
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt){
            buttonAction(evt);
        }
        });
        return button;
    }

    //Action fer each button:
    public void buttonAction(ActionEvent e) {
        String[] options = {"Summon", "Set", "Add Card"};

        int messageType = JOptionPane.QUESTION_MESSAGE;
        int code = JOptionPane.showOptionDialog(
        this, 
        "What would you like to do?", 
        "Card Name", 
        0, messageType, null, 
        options, options[1]);

        if (code==2){
        addCard();
        }
    }
}