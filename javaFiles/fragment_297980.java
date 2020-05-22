userViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
    @Override
    public void onChanged(User user) {
        //Set UI
    }
});