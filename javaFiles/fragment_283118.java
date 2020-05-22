private void proUpdate(){
    if (ETname.getText().toString().trim().equals("")){
        ETname.setText(SharedPrefManager.getInstance(this).getName());
    } 
    if (ETsurname.getText().toString().trim().equals("")){
        ETsurname.setText(SharedPrefManager.getInstance(this).getSurname());
    } 
    if (ETadd.getText().toString().trim().equals("")){
        ETadd.setText(SharedPrefManager.getInstance(this).getAddress());
    } 
    if (ETph.getText().toString().equals("")){
        ETph.setText(SharedPrefManager.getInstance(this).getUserPhone());
    }  
    if (ETmail.getText().toString().trim().equals("")){
        ETmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
    } 
    if (ETpin.getText().toString().equals("")){
        string pin = String.valueOf(SharedPrefManager.getInstance(this).getpin());
           ETpin.setText(pin);
    } 
    updateMethodCall(); // your method call
 }