String input = JOptionPane.showInputDialog(content);
try {
   option = Integer.parseInt(input);
}
catch(NumberFormatException ex) {
   // the user typed nothing, or something that is not an integer
   // TODO: show error message
   // => go to next iteration of while loop.
   continue; 
}
// and now our switch ...