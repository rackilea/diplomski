if(e.getValueIsAdjusting())
 {
   System.out.println("AdjustmentEvent");
 }

 if(scroll.getValueIsAdjusting())
 {
   System.out.println("JScrollBar");
 }

 if(e.getAdjustmentType() == AdjustmentEvent.TRACK) 
 { 
   System.out.println("The button in scrollbar clicked");
 }