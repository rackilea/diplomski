FooApiInterface client = ...;  // initialization

Call<Foo> fooCall = client.getFoo();

fooCall.enqueue(
         new Callback<Foo>() {
              @Override
              public void onResponse(@NonNull Call<Foo> call, @NonNull Response<Foo> response) {
                 if (response.isSuccessful()) {
                     List<String> positiveList = response.body().getPositive();
                     List<String> medicalList = response.body().getMedical();
                 }
              }

              @Override
              public void onFailure(@NonNull Call<Foo> call, @NonNull Throwable t) {
                     Log.e("error", "API Error ", t);
              }
    }
);