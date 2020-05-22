@NonNull
@Override
public Object instantiateItem(@NonNull final ViewGroup view, final int position) {
    View myImageLayout = inflater.inflate(R.layout.slide, view, false);
    ImageView myImage = (ImageView) myImageLayout
            .findViewById(R.id.image);
    myImage.setImageResource(images.get(position));
    myImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(), "page "+position, Toast.LENGTH_SHORT).show();
        }
    });
    view.addView(myImageLayout, 0);
    return myImageLayout;
}