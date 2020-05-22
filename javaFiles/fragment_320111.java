private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();

    if(_bmp!=null){
        int bytes = _bmp.getWidth()*_bmp.getHeight()*4;

        ByteBuffer buffer = ByteBuffer.allocate(bytes);
        _bmp.copyPixelsToBuffer(buffer);

        byte[] array = new byte[bytes]; // looks like this is extraneous memory allocation

        if (buffer.hasArray()) {
            try{
                array = buffer.array();
            } catch (BufferUnderflowException e) {
                e.printStackTrace();
            }
        }

        String configName = _bmp.getConfig().name();

        oos.writeObject(array);
        oos.writeInt(_bmp.getWidth());
        oos.writeInt(_bmp.getHeight());
        oos.writeObject(configName);
    } else {
        oos.writeObject(null);
    }
}

private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
    ois.defaultReadObject();

    byte[] data = (byte[]) ois.readObject();
    if (data != null) {
        int w = ois.readInt();
        int h = ois.readInt();
        String configName = (String) ois.readObject();

        Bitmap.Config configBmp = Bitmap.Config.valueOf(configName);
        Bitmap bitmap_tmp = Bitmap.createBitmap(w, h, configBmp);
        ByteBuffer buffer = ByteBuffer.wrap(data);

        bitmap_tmp.copyPixelsFromBuffer(buffer);

        _bmp = bitmap_tmp.copy(configBmp,true);

        bitmap_tmp.recycle();
    } else {
        _bmp = null;
    }
}