initDataChangeListener();

btnSignUp.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
     if (...) {
      ...
     } else {
       if(mDialog == null) mDialog = new ProgressDialog(SignUp.this);
       mDialog.setMessage("Please Wait...");
       mDialog.show();
       // no need to handle the data, because it's already handled by the data change listener.
     }
   }
});