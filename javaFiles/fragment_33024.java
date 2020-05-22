e.g
     save.setOnClickListener(new View.OnClickListener() {
         @Override
           public void onClick(View view) { boolean chaker =
           saveDataFile.addtoTable(drinkTotalIn); if (chaker == true){
             Toast.makeText(getBaseContext(),"SAVE YOUR
             DATA",Toast.LENGTH_SHORT).show(); }else {
             Toast.makeText(getBaseContext(),"Your Data Not
             Save",Toast.LENGTH_SHORT).show();
     } 
    } 
    });