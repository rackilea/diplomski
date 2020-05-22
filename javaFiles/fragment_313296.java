public void onResponse(Call<SalaryListModel> call, Response<SalaryListModel> response) {
            if (response.isSuccessful()) {
                Log.e(TAG, "onResponse: calling");
                if (response.body().getStatus_code() == 200) {
                    Log.e(TAG, "onResponse: calling 200");

                }
            } else {
                Log.e(TAG, "onResponse: else--");
                if (response.code() == 500) {
                    Log.e(TAG, "onResponse: 500");

                    //and if you want to parse your error body try this

                    /*
                    try {
                        Gson gson = new Gson();
                        YourErrorClass error = gson.fromJson(response.errorBody().charStream(), YourErrorClass.class);

                    } catch (Exception e) {
                         Log.e(TAG, "onResponse error: " + e.getMessage());
                    }*/



                } else if (response.code() == 406) {
                    Log.e(TAG, "onResponse: 406");
                } else {
                    Log.e(TAG, "onResponse: esle");
                }

            }

        }