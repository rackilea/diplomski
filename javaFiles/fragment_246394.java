String email=emailText.getText().toString();
         //check email patterns validation
          if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(context, "Email not valid", Toast.LENGTH_SHORT).show();
             return;
          }else{
               Toast.makeText(context, "Email not valid", Toast.LENGTH_SHORT).show();
                }