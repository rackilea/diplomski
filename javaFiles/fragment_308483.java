public void onResponse(Call<RestServiceResponse> call, Response<RestServiceResponse> response) {

            // code....
            RestServiceResponse restServiceResponse = response.body();

            if (restServiceResponse.getStatusCode() == 200) {

                List<KeyValueItem> list = response.body().getResults();

                for(int i = 0; i < list.size(); i++) {
                     KeyValueItem kvi = list.get(i);
                     // do whatever you want with kvi object
                }
            }
}