public class CopyTextControl2 {
   private CopyTextNorthPanel2 northPanel;
   private CopyTextSouthPanel2 southPanel;

   public void copyAction() {
      if (northPanel != null && southPanel != null) {
         southPanel.setFirstText(northPanel.getNorthFieldText());
      }
   }

   public void setNorthPanel(CopyTextNorthPanel2 northPanel) {
      this.northPanel = northPanel;
   }

   public void setSouthPanel(CopyTextSouthPanel2 southPanel) {
      this.southPanel = southPanel;
   }

}