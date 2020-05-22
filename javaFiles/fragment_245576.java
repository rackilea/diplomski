// --- MapsActivity ---
private static final String EXTRA_TRIGGER_METHOD = "trigger_method";

public static Intent getIntent(Context context, boolean triggerMethod) {
    Intent intent = new Intent(context, MapsActivity.class);
    intent.putExtra(EXTRA_TRIGGER_METHOD, triggerMethod);
    return intent;
}

private boolean triggerMethod;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);

    // here we will assign to triggerMethod the value you passed to the intent when we started this activity
    triggerMethod = getIntent().getBooleanExtra(EXTRA_TRIGGER_METHOD, false);

    if (triggerMethod) {
        methodIWantToCall();
    }
}

// --- AdapterDatos ---
holder.foto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (position == 0) {
            final boolean triggerMethod = true;
            Intent intent = MapsActivity.getIntent(context, triggerMethod);
            context.startActivity(intent);
        }
    }
}