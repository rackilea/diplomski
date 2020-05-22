public class MessagesViewModel extends ViewModel {
    private MutableLiveData<List<message_model>> messagesList;
    public LiveData<List<message_model>> getMessages() {
        if (messagesList == null) {
            messagesList = new MutableLiveData<List<message_model>>();
            loadMessages();
        }
        return messagesList;
    }

    private void loadMessages() {
        MessengerActivity.APIInterface apiInterface = app_net.getRetrofitInstance().create(MessengerActivity.APIInterface.class);
        retrofit2.Call<List<message_model>> call = apiInterface.getMessageDate(Ptoken, date);
        call.enqueue(new Callback<List<message_model>>() {
        @Override
        public void onResponse(Call<List<message_model>> call, Response<List<message_model>> response) {
            if(response.isSuccessful()) {
                if (response.body() != null) {
                    messagesList.setValue(response.body());
                }
            }
        }
        @Override
        public void onFailure(Call<List<message_model>> call, Throwable t) {
            // Handle failure
        }
        });
    }
}