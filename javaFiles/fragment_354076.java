private PaintType getNegativePaintType(String hexa) {
    //hexa = "#28cb43";
    int color = Color.parseColor(hexa);
    int invertedColor = ~color;
    return new SolidColor(Color.argb(Color.alpha(color), Color.red(invertedColor), Color.green(invertedColor), Color.blue(invertedColor)));
}