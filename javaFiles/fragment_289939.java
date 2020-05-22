public static class Item implements Serializable {
    String mName;
    String mColor;
    // more data

    @Override
    public String toString() {
        return mName;
    }
}