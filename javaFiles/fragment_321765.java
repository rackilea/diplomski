Drawable background = view.getBackground();
if (Build.VERSION.SDK_INT >= 21 && background instanceof RippleDrawable) {
    backgroundFromXml = (RippleDrawable) background;
    customRippleDrawable = (RippleDrawable) background.getConstantState().newDrawable().mutate();
    customRippleDrawable.setHotspot(x, y);
    customRippleDrawable.setColor(new ColorStateList(
            new int[][]{
                new int[]{}
            },
            new int[]{
                MainActivity.this.getResources().getColor(R.color.rippleColor)
            }
    ));
    customRippleDrawable.setState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled});
    view.setBackground(customRippleDrawable);
}