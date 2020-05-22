if (response.isSuccessful()) {
    try {
        Log.i("teste", response.body().string());
        movies = parseMovie(json);
        adapter.notifyDataSetChanged(); //add this

    } catch (Exception e) {
        e.printStackTrace();
    }
}