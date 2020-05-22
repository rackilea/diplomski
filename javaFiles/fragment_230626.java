Call<List<Cliente>> call = service.getCliente();
    call.enqueue(new Callback<List<Cliente>>() {
        @Override
        public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>>  response) {
            if(response.isSuccessful()) {
               // your code to get data from the list
            }else{

            }
        }

        @Override
        public void onFailure(Call<List<Cliente>> call, Throwable t) {
            resultadoTextView.setText(t.getMessage());
        }
    });