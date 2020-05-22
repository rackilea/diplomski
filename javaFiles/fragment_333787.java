@Override
 public void windowClosing(WindowEvent e){
       int result = JOptionPane.showConfirmDialog(null, "Are you sure,"Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

       if(result == JOptionPane.YES_OPTION){
               System.exit(0);
       }else{
               //Do nothing
       }
 }