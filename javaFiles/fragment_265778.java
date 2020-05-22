@Override
public void onClick(View v) {
    Button button = (Button) v;
    for (int i = 0; i < textViews.length; i++) {
        if (textViews[i].getTag() == null) {
            textViews[i].setText(button.getText().toString());
            textViews[i].setTag("0");
            break;
        }
    }
}