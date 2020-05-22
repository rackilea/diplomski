private static final int[] imageIds = new int[]{
    R.drawable.image1,
    R.drawable.image2,
    ...};
private static final Drawable[] myImages = new Drawable[imageIds.length];
...
for (int i=0;i<imageIds.length;i++){
    myImages[i] = getResources().getDrawable(imageIds[i])
}