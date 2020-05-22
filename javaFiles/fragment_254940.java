class Typefaces {

  private static final Hashtable<String, Typeface> FONT_CACHE = new Hashtable<>();

  public static Typeface get(Context context, String name) {
      if (!FONT_CACHE.containsKey(name)) {
          Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s.ttf", name));
        FONT_CACHE.put(name, typeface);
      }
      return FONT_CACHE.get(name);
  }

}