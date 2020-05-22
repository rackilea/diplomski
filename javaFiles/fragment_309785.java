Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL_MOVIES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService.MovieDbApi movieDbApi = retrofit.create(MovieService.MovieDbApi.class);

        call = movieDbApi.getReviews(id, API_KEY);

        call.enqueue(new Callback<Reviews>() {
                         @Override
                         public void onResponse(Call<Reviews> call, Response<Reviews> response) {
                             if (!response.isSuccessful()) {
                                 System.out.println("Error");
                             }

                             reviews = response.body();
                             movieReview=reviews.getReviews();
                             movieReviewDetails = movieReview.getResults();

//Print out results

                             for (int i = 0; i < movieReviewDetails.size(); i++) {
                                 System.out.println(movieReviewDetails.get(i).getContent());
                             }

                         }

                         @Override
                         public void onFailure(Call<Reviews> call, Throwable t) {
                             t.printStackTrace();

                         }
                     }
      );