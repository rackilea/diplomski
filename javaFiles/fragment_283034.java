@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_picker_dashboard);
    View bindingRoot = findViewById(R.id.toolbar);

    LayoutHeaderBinding binding = LayoutHeaderBinding.bind(bindingRoot);

    ProfileResponse.Payload profilePayload = new ProfileResponse.Payload();
    profilePayload.setFirstName("Test");

    binding.setProfilePayload(profilePayload);
}