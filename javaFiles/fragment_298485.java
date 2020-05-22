Drawable getDrawable(@NonNull Context context, @DrawableRes int resId, boolean failIfNotKnown) {
    checkVectorDrawableSetup(context);

    Drawable drawable = loadDrawableFromDelegates(context, resId);
    if (drawable == null) {
        drawable = createDrawableIfNeeded(context, resId);
    }
    if (drawable == null) {
        drawable = ContextCompat.getDrawable(context, resId);
    }

    if (drawable != null) {
        // Tint it if needed
        drawable = tintDrawable(context, resId, failIfNotKnown, drawable);
    }
    if (drawable != null) {
        // See if we need to 'fix' the drawable
        DrawableUtils.fixDrawable(drawable);
    }

    return drawable;
}