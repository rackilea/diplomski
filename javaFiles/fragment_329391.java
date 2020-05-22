@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    byte[] b = getIntent().getByteArrayExtra("ImageBit");
    ...
    brandShoe.setText(getIntent().getStringExtra("ShoeName"));
    nameShoe.setText(getIntent().getStringExtra("BrandName"));
}