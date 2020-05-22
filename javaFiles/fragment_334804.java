public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model model = new Model();
        model.getItems().add("first");
        model.getItems().add("second");
        Gson gson = new Gson();
        String json = gson.toJson(model);
        Log.e("json",json);
    }
}