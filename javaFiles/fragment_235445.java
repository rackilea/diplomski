Button button = (Button) findViewById(R.id.button);

if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
    button.setBackgroundDrawable(getMyDrawable());
} else {
    button.setBackground(getMyDrawable());
}