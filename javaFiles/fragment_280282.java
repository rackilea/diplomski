public void onCreate(Bundle savedInstanceState) {
    // Create a ViewModel the first time the system calls an activity's onCreate() method.
    // Re-created activities receive the same MyViewModel instance created by the first activity.

    MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
    model.getAccounts()
}