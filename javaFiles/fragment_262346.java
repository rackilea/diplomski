private void tampilLoker() {
    ApiServices api = InitRetrofit.getInstance();
    Call<ResponseLoker> beritaCall = api.request_show_all_loker();
    beritaCall.enqueue(new Callback<ResponseLoker>() {
        @Override
        public void onResponse(Call<ResponseLoker> call, Response<ResponseLoker> response) {
            if (response.isSuccessful()){
                Log.d("response api", response.body().toString());
                List<LokerItem> data_loker = response.body().getLoker();
                boolean status = response.body().isStatus();
                if (status){
                    AdapterBerita adapter = new AdapterBerita(LowonganKerja.this, data_loker);
                    recyclerView.setAdapter(adapter);
                    //If you want to close your activity here then call finish func here
                    finish();
                 } else {
                    Toast.makeText(LowonganKerja.this, "Tidak ada Lowongan untuk saat ini", Toast.LENGTH_SHORT).show();
                } 
            }
        }