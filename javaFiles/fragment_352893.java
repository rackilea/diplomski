public class Main extends AppCompatActivity implements TextWatcher {

    private EditText etdec, etbi, ethex, etOctal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        etdec = (EditText)findViewById(R.id.etdec);
        etbi = (EditText)findViewById(R.id.etbi);
        ethex = (EditText)findViewById(R.id.ethex);
        etOctal = (EditText)findViewById(R.id.etOct);
        if(etdec) etdec.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                etbi.setEnabled(false);
                ethex.setEnabled(false);
                etOctal.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                kaufort_feld.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(etbi) etbi.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etdec.setEnabled(false);
                ethex.setEnabled(false);
                etOctal.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(ethex) ethex.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etdec.setEnabled(false);
                etbi.setEnabled(false);
                etOctal.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(etOctal) etOctal.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etdec.setEnabled(false);
                etbi.setEnabled(false);
                ethex.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}