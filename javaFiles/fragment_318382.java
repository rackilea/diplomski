public void getTestData(){
    mApiServiceNetwork.getNetworkService(null,WebConstants.API_ENDPOINT)
            .getTestData()
            .enqueue(new Callback<TestModel>() {
                @Override
                public void onResponse(final Call<TestModel> call, final Response<TestModel> response) {
                    if (response.code()==200){
                        //handle the response
                        TestModel testModel = response.body();
                    }else{
                        //handle the error
                    }
                }

                @Override
                public void onFailure(final Call<TestModel> call, final Throwable t) {

                }
            });
}