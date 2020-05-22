@Override  
       protected void onActivityResult(int requestCode, int resultCode, Intent data)  
       {  
                 super.onActivityResult(requestCode, resultCode, data);  
                  // check if the request code is same as what is passed  here it is 2  
                   if(requestCode==2)  
                         {  
                            if(data.getBooleanExtra("isdeleted")){   
                           remove from position array and notify dataset change. // pos = data.getIntExtra("pos") 
                            }
                         }  
     }