private String userId;
@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    userId = sharedPreference.getString("USER_ID",null);
    ...
}