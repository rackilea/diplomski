@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityPickerDashboardBinding binding = 
        DataBindingUtil.setContentView(this, R.layout.activity_picker_dashboard);

    ProfileResponse.Payload profilePayload = new ProfileResponse.Payload();
    profilePayload.setFirstName("Test");

    binding.setProfilePayload(profilePayload);
}