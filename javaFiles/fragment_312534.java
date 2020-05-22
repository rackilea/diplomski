//get a container reference from view
Container pane = view.getPane();

Component[] components = pane.getComponents();
ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //do something with the button click;
        String txt = ((Button)e.getSource()).getText();
        if(txt.equals("bla"){ 
            //do bla
        }
    }
};

for (Component component : components) {
    if (component instanceof JButton) {
        ((JButton) component).addActionListener(actionListener);
    }
}