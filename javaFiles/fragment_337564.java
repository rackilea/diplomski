public class MyActivity extends Activity {

    private static final String KEY_IS_BUTTON_CLICKABLE = "key_clickable";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ...

        final Button register = (Button) findViewById(R.id.register);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean isClickable = sharedPreferences.getBoolean(KEY_IS_BUTTON_CLICKABLE, true);
        register.setEnabled(isClickable);

        if(isClickable) {
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    register.setEnabled(false);

                    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit()
                            .putBoolean(KEY_IS_BUTTON_CLICKABLE, false);

                    Intent register = new Intent(getApplicationContext(), register.class);
                    startActivity(register);
                }
            });
        }
    }
    ...
}