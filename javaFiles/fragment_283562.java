// a one-element array that directly contains itself:
final Object[] a = { null }; a[0] = a;
// a one-element array that contains itself via another one-element array:
final Object[][] b = { { null } }; b[0][0] = b;

// should return true (right?); instead, overflows the stack:
equal(a, b, new ArrayList<Object>(), new ArrayList<Object>());