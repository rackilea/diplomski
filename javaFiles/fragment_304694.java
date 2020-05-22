/** Types of foobangs. */
public enum FB_TYPE {
 GREEN, WRINKLED, SWEET, 
 /** special type for all types combined */
 ALL;
}

/** Counts number of foobangs.
 * @param type Type of foobangs to count
 * @return number of foobangs of type
 */
public int countFoobangs(FB_TYPE type)