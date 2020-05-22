protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDersEkle = (Button) findViewById(R.id.btnDersEkle);
        etDers = new EditText(MainActivity.this);
        LayoutDers = (LinearLayout) findViewById(R.id.layoutDers);
        AlertDialog.Builder alertDers = new AlertDialog.Builder(MainActivity.this);
        alertDers.setTitle("Ders Adi Giriniz");
        alertDers.setView(etDers);
        alertDers.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvDers = new TextView(MainActivity.this);
                tvDers.setText(etDers.getText().toString());
                LayoutDers.addView(tvDers);

            }
        });
        final AlertDialog alert = alertDers.create();

        btnDersEkle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });
    }
}