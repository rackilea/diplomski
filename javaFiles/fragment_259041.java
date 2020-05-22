class GenericWritableRaster extends WritableRaster {
    public GenericWritableRaster(SampleModel model, DataBuffer buffer, Point origin) {
        super(model, buffer, origin);
    }
}

WritableRaster = new GenericWritableRaster(...);