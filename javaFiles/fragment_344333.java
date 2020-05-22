/**
 * Answers a new instance of the same class as the receiver,
 * whose slots have been filled in with the values in the
 * slots of the receiver.
 * <p>
 * Classes which wish to support cloning must specify that
 * they implement the Cloneable interface, since the native
 * implementation checks for this.
 *
 * @return      Object
 *                  a shallow copy of this object.
 * @exception   CloneNotSupportedException
 *                  if the receiver's class does not implement
 *                  the interface Cloneable.
 */
protected native Object clone() throws CloneNotSupportedException;