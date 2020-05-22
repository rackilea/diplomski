public static int getStyledDrawableId(Context context, int attribute)
{
    TypedArray a = context.getTheme().obtainStyledAttributes(new int[] { attribute });
    int id = a.getResourceId(0, -1);
    return id;
}