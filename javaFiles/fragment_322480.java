Call<LoginResponse> call = apiLink.loginUser(useremail, userpassword);

call.enqueue(new Callback<LoginResponse>() {
    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if(!response.isSuccessful()){
            String code = Integer.toString(response.code());
            Toast.makeText(LoginPage.this, code, Toast.LENGTH_LONG).show();
        }
        else {
         LoginResponse postResponse = response.body();

         Log.e("viewResponse", 
               postResponse.getSuccessResponse().toString());

           return;
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Log.e("error in createNewUser",  t.getMessage());
    }
});