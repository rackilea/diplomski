searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String text) {
            return false;
        }
        @Override
        public boolean onQueryTextChange(String text) {
            adapter.filter(text);
            return false;
        }
    });