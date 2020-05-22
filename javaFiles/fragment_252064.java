private Button btnstart;
private Button btnstop;
TimePicker myTimePicker;
final static int RQS_1 = 1;
TimePickerDialog timePickerDialog;
Context context;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    btnstart = (Button)findViewById(R.id.btnstart);
    btnstart.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
            LayoutInflater l = LayoutInflater.from(MainActivity.this);
            View dview = l.inflate(R.layout.dialog, null);
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setView(dview);
            final EditText edit = (EditText) dview.findViewById(R.id.edit);

            ad.setCancelable(false)
            .setTitle("Imposta i Secondi")
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){

                    String e = edit.getText().toString();
                    int n = Integer.parseInt(e);

                Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            Toast.makeText(getApplicationContext(), "Start",Toast.LENGTH_LONG).show();
                        }
                    }, n);

                }
            })
            .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){

                    dialog.cancel();
                }
            });
            AlertDialog alertD = ad.create();

            alertD.show();
        }
    });