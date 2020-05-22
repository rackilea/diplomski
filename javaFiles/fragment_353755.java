decr.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //code to change height and width values of the ImageView

        imageView.getLayoutParams().height = 50; //can change the size according to you requirements
        imageView.getLayoutParams().width = 50; //--
        imageView.requestLayout()
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

    }
});