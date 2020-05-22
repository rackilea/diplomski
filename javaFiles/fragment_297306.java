public class ActivityExample extends MyAppActivity {

    Context context = this;
    AppCompatActivity activity = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.createMyView(R.layout.activity_log_in, R.id.toolbar);
        // ...
    }

 @Override
    public boolean onSupportNavigateUp() {
     finish();
     return true;
    }

}