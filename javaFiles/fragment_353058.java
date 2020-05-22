public void check(Object[] b, int... indices) {
    if (b.getClass().getComponentType().isArray()) {
        //check sub-arrays
        int[] i2 = Arrays.copyOfRange(indices, 1, indices.length);
        check(b[0], i2);
    }
    if (indices[0] > b.length) 
        throw new ArrayIndexOutOfBoundsException("Out of Bounds");
}