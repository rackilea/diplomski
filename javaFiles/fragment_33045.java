public static class CustomAttrFactory implements Factory {

    @Override
    public View onCreateView(String name, Context context,
            AttributeSet attrs) {
        String attributeValue = attrs
                .getAttributeValue(
                        "http://schemas.android.com/apk/res/com.luksprog.droidproj1",
                        "attrnew");
        Log.e("ZXX", "" + attributeValue);
        // if attributeValue is non null then you know the attribute is
        // present on this view(you can use the name to identify the view,
        // or its id attribute)
        return null;
    }
}