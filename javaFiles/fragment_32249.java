Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.custom_border);

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
    this.setBackground(drawable);
} else {
    this.setBackgroundDrawable(drawable);
}