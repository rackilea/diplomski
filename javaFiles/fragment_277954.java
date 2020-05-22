ByteBuffer bb = ByteBuffer.allocate(4*4);
    bb.put(new byte[]{64,-112,0,0,66,-10, 22,-68, 66,9, 73, -43, 63,-114, 56, -38});
    bb.rewind();
    FloatBuffer floatBuffer = bb.asFloatBuffer();


    for(int i = 0; i < 4;i++){
        System.out.println(floatBuffer.get());
    }