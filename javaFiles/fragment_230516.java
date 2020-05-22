private void populateList() {
    MainViewModel viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
    viewModel.makeQuery().observe(MainActivity.this, new Observer<List<Post>>() {
        @Override
        public void onChanged(@Nullable List<Post> posts) {
            adapter = new PostAdapter(posts, getApplicationContext());
            rvPosts.setAdapter(adapter);
            logItems();
        }
    });
}