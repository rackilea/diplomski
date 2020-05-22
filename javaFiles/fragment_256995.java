/**
 * Make this drawable mutable. This operation cannot be reversed. A mutable
 * drawable is guaranteed to not share its state with any other drawable.
 * This is especially useful when you need to modify properties of drawables
 * loaded from resources. By default, all drawables instances loaded from
 * the same resource share a common state; if you modify the state of one
 * instance, all the other instances will receive the same modification.
 *
 * Calling this method on a mutable Drawable will have no effect.
 *
 * @return This drawable.
 * @see ConstantState
 * @see #getConstantState()
 */
public @NonNull Drawable mutate() {
    return this;
}