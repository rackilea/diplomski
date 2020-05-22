public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";

    public static void launch(Context context, String title, String description) {
        Intent intent = new Intent(context, Activity2.class);
        Bundle data = new Bundle();
        data.putString(KEY_TITLE, title);
        data.putString(KEY_DESCRIPTION, description);
        intent.putExtras(data);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String title = bundle.getString(KEY_TITLE);
            String description = bundle.getString(KEY_DESCRIPTION);
        }
    }