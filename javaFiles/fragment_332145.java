public final static int maxTextureSize() {
        /**
         * See http://lwjgl.org/forum/index.php?topic=1314.0;wap2
         */
        IntBuffer max = BufferUtils.newIntBuffer(16);
        max.clear();
        Gdx.gl.glGetIntegerv(GL20.GL_MAX_TEXTURE_SIZE, max);
        return max.get(0);
    }