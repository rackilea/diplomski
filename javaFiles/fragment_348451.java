public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BubblePicker picker = findViewById(R.id.picker);
        picker.setBubbleSize(10);


        final String[] titles = getResources().getStringArray(R.array.planets);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);

        picker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int position) {
                PickerItem item = new PickerItem();
                item.setTitle(titles[position]);
                item.setTextSize(80);
                item.setColor(colors.getColor(position, 0));

                item.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                return item;
            }
        });


        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("planet", item.getTitle());
                startActivity(intent);
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {

            }
        });

    }
}