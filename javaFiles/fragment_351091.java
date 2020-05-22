public class EditAdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ads);

        CircleImageView avatar = findViewById(R.id.avatar);
        EditText nameEditText = findViewById(R.id.edit_text_name);
        Spinner gender = findViewById(R.id.spinner_gender);

        String imageUrl = getIntent().getStringExtra("imageUrl");
        int genderPosition = getIntent().getIntExtra("genderPosition", 0);
        String name = getIntent().getStringExtra("name");

        // Render image view
        Picasso.get()
                .load(imageUrl)
                .into(avatar);

        // Render spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constant.GENDER);
        gender.setAdapter(adapter);
        gender.setSelection(genderPosition);

        // Render edit text
        nameEditText.setText(name);
    }
}