public class ViewAdsActivity extends AppCompatActivity {

    private CircleImageView avatar;
    private EditText name;
    private Spinner gender;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ads);

        avatar = findViewById(R.id.avatar);
        name = findViewById(R.id.edit_text_name);
        gender = findViewById(R.id.spinner_gender);
        next = findViewById(R.id.button_next);


        // Render avatar
        String imageUrl = "https://vignette.wikia.nocookie.net/spiritedaway/images/6/69/Chihiro.jpg/revision/latest?cb=20170308090934";
        avatar.setTag(imageUrl);
        Picasso.get()
                .load(imageUrl)
                .into(avatar);

        // Render spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constant.GENDER);
        gender.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAdsActivity.this, EditAdsActivity.class);

                intent.putExtra("imageUrl", (String) avatar.getTag());
                intent.putExtra("genderPosition", gender.getSelectedItemPosition());
                intent.putExtra("name", name.getText().toString());

                startActivity(intent);
            }
        });
    }
}