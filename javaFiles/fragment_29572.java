LinearLayout ll;
ArrayList<Button> buttons = new ArrayList<Button>();
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // create a layout
    ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);

    for (int i = 0; i < 10; i++) {
        buttons.add(createButton(i));
    }
    Collections.shuffle(buttons);

    for (Button b : buttons) {
        ll.addView(b);
    }

    setContentView(ll);

}

private Button createButton(final int i) {
    Button b = new Button(this);
    b.setText(i + "");
    b.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
                    "Clicking button: " + i, Toast.LENGTH_SHORT).show();
        }

    });
    b.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT));
    return b;
}