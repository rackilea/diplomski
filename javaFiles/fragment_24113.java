public int[] toArray(IntBuffer b) {
    if(b.hasArray()) {
        if(b.arrayOffset() == 0)
            return b.array();

        return Arrays.copyOfRange(b.array(), b.arrayOffset(), b.array().length);
    }

    b.rewind();
    int[] foo = new int[b.remaining()];
    b.get(foo);

    return foo;
}