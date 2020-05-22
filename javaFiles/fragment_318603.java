@Inject SharedPreferencesHelper prefsHelper

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MyApplication.performInjection(this);
}