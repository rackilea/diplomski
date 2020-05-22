public String[] updateArray(String[] src, int size) {

    String[] dest = new String[size];
    if (size > src.length) {

        System.arraycopy(src, 0, dest, 0, src.length);

    } else {

        System.arraycopy(src, 0, dest, 0, size);

    }

    return dest;

}