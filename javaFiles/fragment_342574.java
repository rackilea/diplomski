List<GridLayout.LayoutParams> params = new ArrayList<>();
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        GridLayout.Spec buttonRowSpec = GridLayout.spec(i);
        GridLayout.Spec buttonSpecColumn = GridLayout.spec(j);
        TouchAction actionListener = new TouchAction(gridLayout, buttons, gameController);
        ImageButton button = ButtonsFactory.createImageButton(this, bitmaps[i][j], countPosition, paddingImgBtn, actionListener);
        countPosition++;
        buttons.add(button); // add each button to the collection
        params.add(new GridLayout.LayoutParams(buttonRowSpec, buttonSpecColumn))
    }
}

Collections.shuffle(params); // mix the collection with the buttons

for (int i = 0, size = rows * cols; i < size; i++) {
    ImageButton button = buttons.get(i); // get the buttons from the mixed collection
    // add each button in the GridLayout with the specified parameters
    gridLayout.addView(button, params.get(i)); // add them to GridLayout
}
Bitmap lastImageBitmap = ImageProcessor.resizeImage(getResources(), R.drawable.locked, bitmaps[0][0].getWidth(), bitmaps[0][0].getHeight(), true);
lastButton.setImageBitmap(lastImageBitmap);
buttons.add(lastButton); // add a button with a picture lock at the very end of the collection