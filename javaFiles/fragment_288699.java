while(producingData) {
   this.produceData();
   domainAxis.setRange(
       (((count < 200) || allDataButton.isSelected()) ? 0 : count-200), count);

}