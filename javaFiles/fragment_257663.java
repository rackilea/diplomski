class ButtonExample{
    ArrayList <JButton> buttons = new ArrayList<JButton>();
    ActionListener beh = new ButtonEventHandler()    //this is a custom class that contains actionPerformed() method

    createButtons(){
        for (int i = 0; i < buttons.size(); i++)
            buttons.get(i) = new JButton();
    }

    addListeners(){
        for (int i = 0; i < buttons.size(); i++)
            buttons.get(i).addActionListener(beh);
    }

}