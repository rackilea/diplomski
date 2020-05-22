/**
 * Returns a hash value for the specified object.  In addition to 
 * the object's own hashCode, this method applies a "supplemental
 * hash function," which defends against poor quality hash functions.
 * This is critical because HashMap uses power-of two length 
 * hash tables.<p>
 *
 * The shift distances in this function were chosen as the result
 * of an automated search over the entire four-dimensional search space.
 */
static int hash(Object x) {
    int h = x.hashCode();

    h += ~(h << 9);
    h ^=  (h >>> 14);
    h +=  (h << 4);
    h ^=  (h >>> 10);
    return h;
}