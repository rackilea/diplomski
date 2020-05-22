LinearLayout layout = (LinearLayout)findViewById(R.id.imageLayout);
for(int i=0;i<10;i++)
{
    ImageView image = new ImageView(this);
    image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80,60));
    image.setMaxHeight(20);
    image.setMaxWidth(20);

    // Adds the view to the layout
    layout.addView(image);
}