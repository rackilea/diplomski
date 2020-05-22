AssetManager am = context.getAssets();
String[] files = am.list("images");
InputStream istr = null;
ArrayList<Drawable> drawables = new ArrayList<>();

for (String file : files) {
    Drawable d = Drawable.createFromStream(am.open(file), null);
    drawables.add(d);
}