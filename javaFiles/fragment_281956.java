JOptionPane.showMessageDialog(...);
tempHasBeenEntered = false;
Timer tim = new Timer(5 * 60 * 1000, new ActionListener() { 
                 public void actionPerformed(ActionEvent e) { 
                     if (!tempHasBeenEntered)
                         JOptionPane.showMessageDialog("Hey, enter the temp!!"); 
                 } 
}
tim.setRepeats(false);
tim.start();