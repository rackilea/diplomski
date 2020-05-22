protected View inflateActivityViewInFrame(int layoutId, int titleStringId) {
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(layoutId, mFrameLayout, false);
    mFrameLayout.addView(view);

    setupActionBarAndDrawerToggle(titleStringId);
    return view;
}

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = inflateActivityViewInFrame(
        R.layout.activity_profile, R.string.action_profile);
    initialiseData(view);
}

private void initialiseData(View view) {
    ActivityProfileBinding binding = ActivityProfileBinding.bind(view);
    UserProfile userProfile = new UserProfile("Croaking Tiger Riding Dragon", 8, 16, 32);
    binding.setUserProfile(userProfile);
}