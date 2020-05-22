public class Create implements ActionListener {

   private AdvancedAcmeTaxi taxi;

   // getter method for field
   public AdvancedAcmeTaxi getTaxi() {
      return taxi;
   }

   public Create() {
      ...
   }
   ...

   @Override
   public void actionPerformed(ActionEvent e) {
       taxi = new AdvancedAcmeTaxi(Double.parseDouble(input.getText()));;
       selection.setEnabled(true);
       btnCreate.setEnabled(false);
   }

}