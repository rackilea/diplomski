Resources resources = getResources();
String packageName = getPackageName();
for (int i = 0; i < melodiToner.length; i++) {
    int resId = resources.getIdentifier("gronpil"+melodiToner[i], "drawable", packageName);
    setImageResource(resId);
}