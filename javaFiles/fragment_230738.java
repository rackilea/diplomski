/**
 * Create an expression that returns null if all its arguments
 * evaluate to null, and the value of the first non-null argument
 * otherwise.
 *
 * @param x expression
 * @param y value
 *
 * @return coalesce expression
 */
<Y> Expression<Y> coalesce(Expression<? extends Y> x, Y y);