public interface RetrofitService{
        @GET("/api/registration")
        Call<ResponseBody> registration(paramshere);//function to call api
    }

    RetrofitService service = retrofit.create(RetrofitService.class);
    Call<ResponseBody> result = service.registration(params);
    result.enqueue(new Callback<ResponseBody>() {

    @Override
    public void onResponse(Response<ResponseBody> response) {
        try {
            System.out.println(response.body().string());//convert reponse to string
            Snackbar snackbar = Snackbar
        .make( cont , "Registered successfully",Snackbar.LENGTH_LONG);//pass your activity view as first param
            snackbar.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        e.printStackTrace();
    }
});