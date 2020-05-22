final double[] result = new double[1];
SwingUtilities.invokeAndWait(new Runnable() {
   public void run() {
      try {
         result[0] = Double.parseDouble(
            JOptionPane.showInputDialog("Enter value:"));
      } catch(NumberFormatException e) { 
         result[0] = -1;
      }
   }
}
// ... do something with result[0]