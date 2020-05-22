/**
 * Throws CloneNotSupportedException as a Thread can not be meaningfully
 * cloned. Construct a new Thread instead.
 *
 * @throws  CloneNotSupportedException
 *          always
 */
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}