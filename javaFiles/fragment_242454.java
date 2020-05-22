List<Integer> drawables = Arrays.asList(R.drawable.pic1, R.drawable.pic2, 
      R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6);

List<Integer> buttons = Arrays.asList(R.id.btn1, R.id.btn2, R.id.btn3, 
    R.id.btn4, R.id.btn5, R.id.bt6, R.id.btn7, R.id.btn8, R.id.btn9, 
    R.id.btn10, R.id.btn11, R.id.btn12);

private void setRandomBackground() {
    Collections.shuffle(drawables);
    Collections.shuffle(buttons);

    for (int i = 0, j = 0; i < drawables.size(); i++, j+=2) {
        findViewById(buttons.get(j))
                .setBackgroundResource(drawables.get(i));
        findViewById(buttons.get(j+1))
                .setBackgroundResource(drawables.get(i));
    }

}