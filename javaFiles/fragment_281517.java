Object actualOriginal = new Object();
Object original[] = new Object[] {actualOriginal};
...
public static void changePointer(Object[] param) {
    param[0] = new Object();
    //Change the pointer of original
}
...
// original[0] now has a reference to whatever you set in changePointer(..)