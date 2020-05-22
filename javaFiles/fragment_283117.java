private void proUpdate(){
       ...
        else if (ETpin.getText().toString().equals("")){
           string pin = String.valueOf(SharedPrefManager.getInstance(this).getpin());
           ETpin.setText(pin);
        }
       ...
     }