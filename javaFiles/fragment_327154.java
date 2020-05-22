Call<Model> call = service.getModel();
call.enqueue(new Callback<Model>() {
@Override
public void onResponse(Response<Model> response) {
// Get result Model from response.body()
}

@Override
public void onFailure(Throwable t) {
}
});