/**
 * Return all Windows
 *
 * @return Iterator of all Windows
 * @treatAsPrivate implementation detail
 * @deprecated This is an internal API that is not intended for use and will be removed in the next version
 */
@Deprecated
@NoInit
public static Iterator<Window> impl_getWindows() {
    final Iterator iterator = AccessController.doPrivileged(
        new PrivilegedAction<Iterator>() {
            @Override public Iterator run() {
                return windowQueue.iterator();
            }
        }
    );
    return iterator;
}