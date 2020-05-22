Bundle extras = getIntent().getExtras();
if(extras != null){
   if(extras.getString("Action") != null)
      if (extras.getString("Action").equals("A")) {
        //DO SOMETHING
      }
   }  
 if(extras.getString("Action2") != null)
      if (extras.getString("Action2").equals("A2")) {
        //DO SOMETHING
      }
   }  
}