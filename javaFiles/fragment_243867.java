call.enqueue(new Callback<List<Koor>>() {
            @Override
            public void onResponse(Call<List<Koor>> call, Response<List<Koor>> response) 
               {
                koorArrayList = response.body();
                 Koor mKoor = koorArrayList.get(koorArrayList.size() - 1);
                }

          ..............