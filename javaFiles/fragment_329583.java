java.util.Enumeration<AbstractButton> rbs=buttonGroup1.getElements(); 
 while(rbs.hasMoreElements()){
       JRadioButton tempRadio = (JRadioButton)rbs.nextElement();
          if(tempRadio.isSelected()){
               System.out.println("Selected : "+tempRadio.getText());
               break;
              }
         }