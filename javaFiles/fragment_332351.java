public void login() {
    if(mApiService==null)
         mApiService = new RetrofitClient(baseUrl).getService();
    mApiService.userLogin(loginUsername.getText().toString(), loginPassword.getText().toString())
            .enqueue(new Callback<User>() {

                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.d(TAG, "onResponse: "+loginUsername.getText().toString()+loginPassword.getText().toString());
                    Log.d(TAG, "onResponse: "+response.body());
                    if (response.isSuccessful()) {
                        loading.dismiss();
                        try {
                            JSONObject jsonRESULTS = new JSONObject(response.body().toString());
                            if (jsonRESULTS.getString("error").equals("false")) {
                                Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                Intent intent = new Intent(mContext, MainActivity.class);
                                intent.putExtra("result_nama", nama);
                                startActivity(intent);
                            } else {
                                String error_message = jsonRESULTS.getString("error_msg");
                                Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        loading.dismiss();
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
}