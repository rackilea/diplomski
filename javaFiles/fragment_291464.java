public static void setCursorColor(EditText view, @ColorInt int color) {
  try {
    // Get the cursor resource id
    Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
    field.setAccessible(true);
    int drawableResId = field.getInt(view);

    // Get the editor
    field = TextView.class.getDeclaredField("mEditor");
    field.setAccessible(true);
    Object editor = field.get(view);

    // Get the drawable and set a color filter
    Drawable drawable = ContextCompat.getDrawable(view.getContext(), drawableResId);
    drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    Drawable[] drawables = {drawable, drawable};

    // Set the drawables
    field = editor.getClass().getDeclaredField("mCursorDrawable");
    field.setAccessible(true);
    field.set(editor, drawables);
  } catch (Exception ignored) {
  }
}