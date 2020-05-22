for (int i = 0; i < 20; i++) {
    Button buttons = new Button(this);
    buttons.setText("heh" + (i + 1));
    buttons.setY(button.getY() + 20 *i ); // <- Remove this
    buttons.setLayoutParams(linearParams);
    linearLayout.addView(buttons);
}