public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CirclesView circlesView = new CirclesView(this);
        setContentView(circlesView);
    }
}