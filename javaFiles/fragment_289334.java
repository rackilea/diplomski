TextView[]  textViews1 = new TextView[7];
TextView[]  textViews2 = new TextView[7];
ImageView[]  imageViews = new ImageView[7];

for (int j = 0; j < 7; j++) {
    String viewmt = "mt" + (i + 1);
    String viewtid = "tid" + (i + 1);
    String viewImage = "imageView" + (i + 1);
    int resIDmt = getResources().getIdentifier(viewmt, "id", getPackageName());
    int resIDtid = getResources().getIdentifier(viewtid, "id", getPackageName());
    int resIDImage = getResources().getIdentifier(viewImage, "id", getPackageName());

    textViews1[j] = ((TextView) v.findViewById(resIDmt));
    textViews2[j] = ((TextView) v.findViewById(resIDtid));
    imageViews[j] = ((ImageView) v.findViewById(resIDImage));
}