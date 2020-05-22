setValueTask.addOnCompleteListener(new OnCompleteListener<Void>() {
   @Override
   public void onComplete(@NonNull Task<Void> task) {
      if(task.isSuccessful()){
         tcs.setResult(true);
      }else{
         tcs.setResult(false);
      }
   }
});