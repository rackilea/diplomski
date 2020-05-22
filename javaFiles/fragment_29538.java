static ByteBuffer getTemporaryDirectBuffer(int var0) {
    Util.BufferCache var1 = (Util.BufferCache)bufferCache.get();
    ByteBuffer var2 = var1.get(var0);
    if(var2 != null) {
        return var2;
    } else {
        if(!var1.isEmpty()) {
            var2 = var1.removeFirst();
            free(var2);
        }

        return ByteBuffer.allocateDirect(var0);
    }
}