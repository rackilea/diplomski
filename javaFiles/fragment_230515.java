public void logItems() {
    adapter.setListener(new AdapterCallback() {
        @Override
        public void onMethodCallback(int id) {
            MainViewModel viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
            viewModel.makeSingleQuery(id).observe(MainActivity.this, new Observer<Post>() {
                @Override
                public void onChanged(@Nullable final Post post) {
                    Log.d(TAG, "onChanged: data response");
                    Log.d(TAG, "onChanged: " + post);
                }
            });
        }
    });
}