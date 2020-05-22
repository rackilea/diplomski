ButtonGroup buttonGroup = new ButtonGroup();
for(String s : portTab){                    
    JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem();  
    checkBoxMenuItem.setText(s);
    buttonGroup.add(checkBoxMenuItem);
    checkBoxMenuItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO 
        }
    });         
}