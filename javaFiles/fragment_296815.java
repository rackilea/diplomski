apiService.getCurrency(url.toString())
       .enqueue(new Callback<List<MyModel>>() {

        @Override
        public void onResponse(Call<List<MyModel>> call, retrofit2.Response<List<MyModel>> response) {
            // your response
        }

        @Override
        public void onFailure(Call<List<MyModel>> call, Throwable t) {

        }

    });