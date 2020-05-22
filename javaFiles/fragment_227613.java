List<Movie> mList = new ArrayList<Movie>();

for (int i = 0 ; i < 5 ; i++) {
    final int x = i;  // or anything else, but you must assign it some value
    mList.add(new Movie() {
        @Override
        public String toString(){
            return "Movie" + x;
        } 
    });
}