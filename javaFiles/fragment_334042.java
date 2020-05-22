/**
 * Loads the layout and sets the initial set of images
 */
private void prepareLayout() {
    LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.myprogressbar, null);
    addView(view);

    imageHolders = new ArrayList<ImageView>();
    imageHolders.add((ImageView) view.findViewById(R.id.imgOne));
    imageHolders.add((ImageView) view.findViewById(R.id.imgTwo));
    imageHolders.add((ImageView) view.findViewById(R.id.imgThree));

    // Prepare an array list of images to be animated
    images = new ArrayList<String>();

    images.add("progress_1");
    images.add("progress_2");
    images.add("progress_3");
    images.add("progress_4");
    images.add("progress_5");
    images.add("progress_6");
    images.add("progress_7");
    images.add("progress_8");
    images.add("progress_9");
}