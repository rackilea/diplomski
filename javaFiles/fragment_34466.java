int[] cmap = new int[65536];
for(int i = 0; i < 65536; ++i) {

    cmap[i] = (((i % 10000) * 256 / 10000) << 16) 
            | (((i % 20000) * 256 / 20000) << 8)
            | (((i % 40000) * 256 / 40000) << 0);
}
ColorModel model = new IndexColorModel(16, 65536, cmap, 0, false, -1, DataBuffer.TYPE_USHORT);