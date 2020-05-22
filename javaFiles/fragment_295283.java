public FloatBuffer fBuffer(){
        ShortBuffer sb = ShortBuffer.allocate(4);
        sb.put(new short[]{256,256,128,64});

        short[] shortArr = sb.array();  
        ByteBuffer bb = ByteBuffer.allocate(shortArr.length * 2);
        bb.asShortBuffer().put(shortArr);

        return bb.asFloatBuffer();
    }