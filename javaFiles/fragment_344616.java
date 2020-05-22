ImageGetter imageGetter = new ImageGetter() {

    @Override
    public Drawable getDrawable(String source) {
        Drawable d = getResources().getDrawable(R.drawable.yourimage);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        return d;
    }
};

Spanned spanned = Html.fromHtml(
    "<img src='" + getResources().getDrawable(R.drawable.yourimage) + "'/>", imageGetter, null);