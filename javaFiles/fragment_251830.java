public final void setName(String name) {
      stepName.setValue(name);
   }



   public final String getName() {
      return stepName.getValue();
   }


   public StringProperty nameProperty() {
      return stepName;
   }