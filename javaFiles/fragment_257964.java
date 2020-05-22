public class MainActivity extends AppCompatActivity {
    ...
    GenerateDialog generateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ...

        generateDialog = new GenerateDialog(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateDialog.show();
            }
        });
    }
}