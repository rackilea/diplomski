public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Typeface typeface = FontHelper.getCustomTypeFace(this);
        ...
    }
}