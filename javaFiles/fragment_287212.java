private static float[] toFloatArray(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        FloatBuffer fb = buffer.asFloatBuffer();

        float[] floatArray = new float[fb.limit()];
        fb.get(floatArray);


        return floatArray;
    }