@Test(expected = MatrixException.class)
public void testCheckBounds_NegativeRow() {  // m is a 4x3 matrix
    // You must have defined m somewhere else as a member variable.
    m.get(-1, 2);
}

@Test(expected = MatrixException.class)
public void testCheckBounds_LargerThanMaxRow() {  // m is a 4x3 matrix
    // You must have defined m somewhere else as a member variable.
    m.get(10, 2);
}

@Test(expected = MatrixException.class)
public void testCheckBounds_NegativeColumn() {  // m is a 4x3 matrix
    // You must have defined m somewhere else as a member variable.
    m.get(1, -2);
}

@Test(expected = MatrixException.class)
public void testCheckBounds_LargerThanMaxColumn() {  // m is a 4x3 matrix
    // You must have defined m somewhere else as a member variable.
    m.get(1, 20);
}

@Test
public void testCheckBounds_Success() {
    // what should you asset here?  It's not a useful method.  I'd return boolean
    m.get(1,1);
}