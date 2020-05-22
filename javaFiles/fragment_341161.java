public void actionPerformed(ActionEvent actionevent) {
   //you can test if the event has come in from the timer
   if (actionevent.getSource() == myTimer) {
    while(count<999999999&&explodePercent>=0){
      if(explodePercent>0)    
         explodePercent=explodePercent-.0001;
      else
         explodePercent=explodePercent+.0001;
      getPlot().setExplodePercent("One", explodePercent);
     count++;
    }
   }
 }