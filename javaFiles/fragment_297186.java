LayerDrawable icon = null;
    Drawable drawable = cartItem.getIcon();
    if (drawable instanceof DrawableWrapper) {
        drawable = ((DrawableWrapper)drawable).getWrappedDrawable();
    }
    icon = (LayerDrawable) drawable;