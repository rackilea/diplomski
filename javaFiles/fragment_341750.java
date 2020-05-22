private int availableUsers=0;

   public void checkNumber() {
      this.checkNumber(0);
   }
   private void checkNumber(final int i){
        if(contactsString==null || i>=contactsString.length){
           return;
        }
        Phone phone=new Phone();
        phone.phone=contactsString[i];
        WebService.getInstance().getApi().checkNumber(phone).enqueue(new Callback<MainResponse>() {

            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {


                availableUsers++;                    
                checkNumber(i+1);

            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {  
               checkNumber(i+1);

            }
        });
}