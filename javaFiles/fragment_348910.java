public static void openProfile(Activity activity, View v) {
    View row = (View) v.getParent();

    TextView child2 = (TextView) row.findViewById(R.id.genFromlogin);
    String child3 = child2.getText().toString();

    Intent ini = activity.getIntent();
    String c_username = ini.getStringExtra(MainActivity.KEY_USERNAME);
    String c_password = ini.getStringExtra(MainActivity.KEY_PASSWORD);
    Intent ini2 = new Intent(activity, User.class);
    ini2.putExtra(MainActivity.KEY_USERNAME, c_username);
    ini2.putExtra(MainActivity.KEY_PASSWORD, c_password);
    ini2.putExtra(MainActivity.KEY_USER, child3);
    activity.startActivity(ini2);
}