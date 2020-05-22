void convert(InputStream in, BitFileWriter out) {
    HuffmanTree huffman = new HuffmanTree()
    int b;
    while ((b = in.read()) != -1) {
        huffman.add(b);
        Bits bits = huffman.get(b);
        for (int bit : bits.values()) {
             out.writeBit(bit);
        }
    }
    out.close();
}