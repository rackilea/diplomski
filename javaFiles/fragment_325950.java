public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if(response.isSuccessful())
                    {
                        result=response.body();
                        Log.e(TAG, "onCreate: "+result );

                       adapter=new DisplayAdapter(getApplicationContext(),result);
                       RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),1);
                       movieList.setLayoutManager(layoutManager);
                       movieList.setAdapter(adapter);
                    }
                }