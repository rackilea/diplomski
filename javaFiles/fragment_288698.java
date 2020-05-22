while(producingData) {
   this.produceData();
   if(!allDataButton.isSelected()) {
      domainAxis.setRange((count < 200) ? 0 : count-200), count);
    } else {
      domainAxis.setRange(0, count);
    }
}