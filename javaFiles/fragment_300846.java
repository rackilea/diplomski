User user = new User(123, "John Doe");
Call<User> call = apiService.createuser(user);
call.enqueue(new Callback<User>() {
  @Override
  public void onResponse(Call<User> call, Response<User> response) {
  }

  @Override
  public void onFailure(Call<User> call, Throwable t) {
  }