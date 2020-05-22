Call<List<YoutubePost>> call = youtubeApiInterface.getPlayList();
call.enqueue(new Callback<List<YoutubePost>>() {
        @Override
        public void onResponse(Call<List<YoutubePost>> call, Response<List<YoutubePost>> response) {
            if (response.isSuccessful()) {

            } else {

            }
        }.

        @Override
        public void onFailure(Call<List<YoutubePost>> call, Throwable t) {
            t.printStackTrace();

        }
    });