private ActionListener btnListener = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "0": 
            case "1": 
               // ...
            case "9":
                enterDigit(event.getActionCommand());
                break;                    
        }
    }
};

public gui(){
    one = new JButton("1");
    one.setActionCommand("1");
    one.addActionListener(btnListener);
    two = new JButton("2");
    two.setActionCommand("2");
    two.addActionListener(btnListener);
    // ...
}