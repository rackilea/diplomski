public void filter(CharSequence text){
    String query = text.toString().toLowerCase();
    tempMovies.clear();
    if(text.length() == 0){
        tempMovies.addAll(originalMoviesList);
    } else{
        for(Movies m : originalMoviesList){
            if(m.toString().toLowerCase().contains(query)){
                tempMovies.add(m);
            }
        }
    }
    notifyDataSetChanged();
}