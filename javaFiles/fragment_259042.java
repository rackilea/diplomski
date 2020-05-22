public class BufferTest {
    public static void main(String[] args) {
        Dimension dim = new Dimension(100, 100);
        int size = dim.width * dim.height;

        final IntBuffer buf = IntBuffer.wrap(new int[size]);

        DataBuffer dbuf = new DataBuffer(DataBuffer.TYPE_INT, size) {
            public void setElem(int bank, int i, int val) {
                buf.put(i, val);
            }

            public int getElem(int bank, int i) {
                return buf.get(i);
            }
        };
        ColorModel cm = ColorModel.getRGBdefault();
        SampleModel sm = cm.createCompatibleSampleModel(dim.width, dim.height);
        WritableRaster raster = new WritableRaster(sm, dbuf, new Point()) {};
        BufferedImage img = new BufferedImage(cm, raster, false, null);

        System.err.println("img: " + img);
    }
}