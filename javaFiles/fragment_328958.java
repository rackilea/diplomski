private void shuffleButtons() {
  top_layout.removeAllViews();
  middle_layout.removeAllViews();
  Collections.shuffle(buttonList);

  for (int i = 0; i<6; i++) {
    if (i <3) {
      top_layout.addView(buttonList.get(i))
    } else {
      middle_layout.addView(buttonList.get(i));
    }
  }
}