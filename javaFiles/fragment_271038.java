@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {


    ....

    String selectedImage = getIntent().getStringExtra("SELECTED_IMAGE");
    Glide.with(this).load(selectedImage).into(image_view);
}