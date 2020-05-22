CustomActionListener listener = new CustomActionListener();

for (int i=0; i<btns.length; i++){
   buttons[i].addActionListener(listener);
}

class CustomActionListener implements ActionListener {
     public void actionPerformed(ActionEvent e) {
         // Handle click on buttons
         // Use e.getSource() to get the trigger button
         JButton button = (JButton) e.getSource();
     }
}