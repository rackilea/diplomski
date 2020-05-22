public class MainActivity extends AppCompatActivity {
    private DialogPlus dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = DataConnect.showDialog(this);
    }


    @Override
    public void onBackPressed() {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            } else {
                super.onBackPressed();
            }
    }
}