public Drawable getDrawable(Resources res, int id, Theme theme)
        throws NotFoundException {
    final int version = Build.VERSION.SDK_INT;
    if (version >= 21) {
        return ResourcesCompatApi21.getDrawable(res, id, theme);
    } else {
        return res.getDrawable(id);
    }
}