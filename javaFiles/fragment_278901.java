public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastClass toastClass = new ToastClass();
        toastClass.toast(getApplicationContext(), "Hey dude!!");
    }
}