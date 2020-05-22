DataChangeListener lst = new DataChangeListener() {
     @Override public void dataChanged(DataChangeEvent e) {
         String ticker = e.getSource();
         String field = e.getDataName();
         double oldValue = e.getOldValue().asDouble();
         double newValue = e.getNewValue().asDouble();
     }
};