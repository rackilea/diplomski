Call<DeviceModel> call = client.newCall(request);
   call.enqueue(new Callback<DeviceModel>() {
     public void onResponse(Call<DeviceModel> call, Response<DeviceModel> response) throws IOException {
       try (DeviceModel model = response.body()) {
         // TODO: use model
       }
     }

     public void onFailure(Call call, IOException e) {
       ... // Handle the failure.
     }
   });