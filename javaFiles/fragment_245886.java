searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String txt) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String txt) {

            //Do network call from here.
            doSearch(txt);

            return false;
        }
    });

  void doSearch(String query){
   String url = "https://www.googleapis.com/books/v1/volumes?q="+query+"&maxResults=10";
    ....
  }