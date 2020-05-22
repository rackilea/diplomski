static void subtractAlphaSecondFromFirst (ByteBuffer first, ByteBuffer second, int pixelCount) {
    for (int i = 3; i < pixelCount * 4; i = i + 4) {
        byte a = first.get(i);
        first.put(i, (b > a ? 0 : a-b));
    }
}