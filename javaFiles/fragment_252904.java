public class MainActivity extends Activity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new Builder(MainActivity.this);

        Spanned message = Html.fromHtml(getString(R.string.text));
        final SpannableString str = new SpannableString(message);
        Linkify.addLinks(str, Linkify.ALL);

        builder.setMessage(str);

        builder.setPositiveButton("OK", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        dialog = builder.create();

        TextView t = (TextView) findViewById(R.id.textView1);
        t.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                dialog.show();

                // This must be called after dialog.show();
                ((TextView)dialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

                return false;

            }
        });


    }

}