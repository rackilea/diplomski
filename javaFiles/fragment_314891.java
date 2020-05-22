public void init() {  
        // set the layout to FlowLayout
        container.setLayout(new FlowLayout());
        // register the 'this' action listener for the button
        button.addActionListener(this);
        container.add(button);
}