public void addComponents(Container pane) {
    JPanel buttons = new JPanel();
    counter = new int[2]; //Move this line to here...
    JButton bpmButton = new JButton("Click");
    bpmButton.setSize(new Dimension(100, 50));
    bpmButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            buttonPressed++;                
            if (buttonPressed == 1) {
                counter[0] = (int)(System.currentTimeMillis());
            }   else if (buttonPressed == 2) {
                counter[1] = (int)(System.currentTimeMillis());
                calculateTimeBetweenClicks();
                setTime();
            } //Removed the else - see edit below :-)
        }
    });