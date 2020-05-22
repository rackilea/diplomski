res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String>call, Response<String> response) {
              // response.body(); // to get the response
            }

            @Override
            public void onFailure(Call<String>call, Throwable t) {
            }
        });