final int layoutDirection = getLayoutDirection();
final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;

switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
    case Gravity.CENTER_HORIZONTAL:
        ...
    case Gravity.RIGHT:
        ...
    case Gravity.LEFT:
        ...
}

switch (verticalGravity) {
    case Gravity.TOP:
        ...
    case Gravity.CENTER_VERTICAL:
        ...
    case Gravity.BOTTOM:
        ...
}