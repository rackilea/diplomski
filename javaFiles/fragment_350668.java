JToggleButton jtb = new JToggleButton("Press Me");
jtb.addItemListener(new ItemListener() {
   public void itemStateChanged(ItemEvent ev) {
      if(ev.getStateChange()==ItemEvent.SELECTED){
        System.out.println("button is selected");
      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
        System.out.println("button is not selected");
      }
   }
});