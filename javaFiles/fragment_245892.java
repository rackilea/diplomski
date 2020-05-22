private List<message_model> messages = new ArrayList<>();
private void synchronization() {
getDateMessage(upadated_at);
    // Anything you put here will be called before the data (messages) is loaded.
    // Do not work with your messages here, they'll be null.
}
  private void getDateMessage(String date) {
    MessengerActivity.APIInterface apiInterface = app_net.getRetrofitInstance().create(MessengerActivity.APIInterface.class);
    retrofit2.Call<List<message_model>> call = apiInterface.getMessageDate(Ptoken, date);
    call.enqueue(new Callback<List<message_model>>() {
        @Override
        public void onResponse(Call<List<message_model>> call, Response<List<message_model>> response) {
            if(response.isSuccessful()) {
                messages.addAll(response.body());
                Log.e("MSDF",response.body().toString()+" responsebody in call");
                Log.e("MSDF",messages.toString()+" message in call");
                Log.e("MESSAGE", "getDateMessage successful");
                // Anything you want to do with the messages should be placed here. When you are sure the data is completed. 
                Log.e("MSDF",messages.toString()+" list tostring");
            }
        }
        @Override
        public void onFailure(Call<List<message_model>> call, Throwable t) {
            Log.e("MESSAGE", "getDateMessage" + t.toString());
        }
    });
}