public class IpDiscoveryDialog extends AlertDialog implements View.OnClickListener {

private View view;
private Context context;
private Activity activity;

private EditText ipEditText;


protected IpDiscoveryDialog(Context context) {
    super(context);
    this.context = context;
}

public IpDiscoveryDialog(Context context, Activity activity) {
    this(context);
    this.activity = activity;
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.ip_discovery_dialog);
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    buildView();
    this.setCancelable(false);
}

private void buildView() {
    findViewById(R.id.ipConfirmButton).setOnClickListener(this);
    this.ipEditText = findViewById(R.id.ipEditText);
}

@Override
public void onClick(View v) {

}
}