public class Chooser extends Activity implements OnClickListener {
    private static final int NUM = 6;
    private static final CharSequence DEFAULT = "click for select the app, long click to clear it";

    private Intent[] mIntents = new Intent[NUM];
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = new LinearLayout(this);
        mLayout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < NUM; i++) {
            Button b = new Button(this);
            b.setTag(i);
            b.setText(DEFAULT);
            b.setOnClickListener(this);
            registerForContextMenu(b);
            mLayout.addView(b);
        }
        setContentView(mLayout);
    }

    private CharSequence getName(Intent intent) {
        PackageManager mgr = getPackageManager();
        ResolveInfo info = mgr.resolveActivity(intent, 0);
        if (info != null) {
            return info.loadLabel(mgr);
        }
        return intent.getComponent().getShortClassName();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        int itemId = (Integer) v.getTag();
        if (mIntents[itemId] != null) {
            menu.add(Menu.NONE, itemId, Menu.NONE, "Clear");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int i = item.getItemId();
        Button b = (Button) mLayout.getChildAt(i);
        b.setText(DEFAULT);
        mIntents[i] = null;
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Button b = (Button) mLayout.getChildAt(requestCode);
            b.setText(getName(data));
            mIntents[requestCode] = data;
            startActivity(data);
        }
    }

    @Override
    public void onClick(View v) {
        int i = (Integer) v.getTag();
        if (mIntents[i] == null) {
            Intent intent = new Intent(Intent.ACTION_PICK_ACTIVITY);
            Intent filter = new Intent(Intent.ACTION_MAIN);
            filter.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.putExtra(Intent.EXTRA_INTENT, filter);
            startActivityForResult(intent, i);
        } else {
            startActivity(mIntents[i]);
        }
    }
}