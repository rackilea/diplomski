public static boolean personalMain = true;

private Activity activity = this;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (personalMain) {
        new HomeScreenPersonal(activity);
    } else {
        new HomeScreenBusiness(activity);
    }
}