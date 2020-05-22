public void onResponse(Call<com.aamir.friendlocator.friendlocator.Models.SendLocation> call, Response<com.aamir.friendlocator.friendlocator.Models.SendLocation> response) {
                Log.d("Response", response.body().getUserKey());
                if (!response.body().getUserKey().isEmpty()) {

                    String userKey = response.body().getUserKey();
                    textViewKeyDisplay.setText(userKey);

                    // Writing data to SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("key", userKey);
                    if(editor.commit()){
                        Log.d("saved","saved");
                    }
                }  
            }