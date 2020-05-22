public class MainActivity extends Activity {

    TextView Laura_Aikman;
    TextView Sarah_Alexander;
    TextView Anthony_Andrews;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] option = new String[]{"Call", "SMS", "Save", "Share"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, option);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // for making call
                if (which == 0) {
                    Toast.makeText(MainActivity.this,
                            "Calling to:" + mobileNumber, Toast.LENGTH_SHORT)
                            .show();
                    Intent intent = new Intent(Intent.ACTION_CALL);

                    intent.setData(Uri.parse("tel:" + mobileNumber));
                    startActivity(intent);
                }

            }
        });

        final AlertDialog dialog = builder.create();

        Laura_Aikman = (TextView) findViewById(R.id.Laura_Aikman);
        Laura_Aikman.setTag("11111111111111");
        Laura_Aikman.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mobileNumber = v.getTag().toString();
                dialog.show();

            }
        });

        Sarah_Alexander = (TextView) findViewById(R.id.Sarah_Alexander);
        Sarah_Alexander.setTag("22222222222");
        Sarah_Alexander.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mobileNumber = v.getTag().toString();
                dialog.show();
            }
        });

        Anthony_Andrews = (TextView) findViewById(R.id.Anthony_Andrews);
        Anthony_Andrews.setTag("333333333333");
        Anthony_Andrews.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mobileNumber = v.getTag().toString();
                dialog.show();
            }
        });
    }

}