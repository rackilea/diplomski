Call<Response> auth = .// setup
        auth.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if (response.isSuccessful() ) {
                      Response respojo = response.body();
                     if(respojo.getStatus().equals("success"){
                         Log.i("User: ","" + respojo.getUser().getFullname());
                      }else {
                         Log.i("Error: ","" + respojo.getReason());
                      }  
                    }
                } else {
                   response.errorBody(); 

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });