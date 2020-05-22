call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            Log.d("Postavke", "Reached onResponse");
            if (!response.isSuccess()) {
                Log.d("Postavke", "No Success");
            }else{
                Log.d("Postavke", "responsebody  => "+ response.body().toString());
            }


        }

        @Override
        public void onFailure(Call<ResponseBody> call,Throwable t) {
            // Toast for the moment
            // Appropriate error handling code should be present here
            Toast.makeText(Postavke.this, "Failed !", Toast.LENGTH_LONG).show();
        }
    });