Component[] components = getContentPane().getComponents();

for (int i = 0; i < components.length; ++i) {
   if ((components[i] instanceof Container)) {
       Container subContainer = (Container)components[i];
       //do something here
   }else{
       //do something here
   }
}