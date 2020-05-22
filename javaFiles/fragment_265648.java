private void loadFromWS(Object object) {
        Call<Object> call = new RetrofitInicializador().getObjectService().postexemple(object);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object response = response.body();

               // DO your stuffs
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(AgendaActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
            }
        });
    }