viewModel.getStateLiveData ().observe(this, new Observer<>() {
    @Override
    public void onChanged(State state) {
         //do something here
    }
});