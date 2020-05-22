@Command
     public void  showVisibleRadio(){

       if (value.isChecked()){
       value.setChecked(false);
       }
       else{
       value.setChecked(true);
      }
    }