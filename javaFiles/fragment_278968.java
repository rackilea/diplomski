// in ViewModel
taskRunner.executeAsync(new LongRunningTask(input), (data) -> {
    // MyActivity activity = activityReference.get();
    // activity.progressBar.setVisibility(View.GONE);
    // populateData(activity, data) ;

    loadingLiveData.setValue(false);
    dataLiveData.setValue(data);
});

// in Activity
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main_activity);

    viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
    viewModel.loadingLiveData.observe(this, (loading) -> {
        if(loading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    });

    viewModel.dataLiveData.observe(this, (data) -> {
        populateData(data);
    }); 
}