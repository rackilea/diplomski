// trivial one.
return new ArrayList<E>();

// If F is a super type of E, then the following line is valid too.
return new ArrayList<F>();

// The following will also be valid, since Object is a super type of all
// other types.
return new ArrayList<Object>();