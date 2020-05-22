private EditText txtX;
    private EditText txtF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtX=(EditText)findViewById(R.id.X);
        txtF=(EditText)findViewById(R.id.F);
    }


    public void Calculate() {
        boolean ok = true;
        double x = 0;

        try {
            x = leeDouble(txtX);

        } catch (NumberFormatException e) {
            ok = false;
        }
        double f = 0;
        try {
            f = leeDouble(txtF);
        } catch (NumberFormatException e) {
            ok = false;
        }

        if (ok) {
            final double divisor = x - 2 * f;
            if (Math.abs(divisor) > 0.0005) {
                double a = (2 * x + f) / divisor;
                message("a=" + a);
            } else {
                message("Wrong numbers");
            }
        }
    }
    private void message(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    private double leeDouble(EditText editText) throws NumberFormatException{
        try{
            return Double.parseDouble(editText.getText().toString().trim());
        } catch(NumberFormatException e){
            editText.setError("Wrong number");
            throw e;
        }  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_calculate) {
            Calculate();
        }
        return super.onOptionsItemSelected(item);
    }
}