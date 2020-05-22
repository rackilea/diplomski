for(int i=0;i < treeTypes.length;i++){
             try{
             desiredYield[index] = Integer.parseInt(JOptionPane.showInputDialog("Please enter your desired yield for: " +treeTypes[i]));
        }catch(NumberFormatException e){
           if(desiredYield[index]==("") || desiredYield[index]<0){
              JOptionPane.showMessageDialog(null, "Error: Please enter your desired yield for "+treeTypes[i]);
          }else{
              index++
        }
   }