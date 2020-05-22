static class ArrayHolder 
{ 
    private byte[] _bytes; 

    ArrayHolder(final byte[] bytes) { _bytes = bytes.clone(); } 

    byte[] getBytes() { return _bytes.clone(); } 

    @Override 
    protected void finalize() throws Throwable 
    { 
        if (_bytes != null) 
        { 
            Arrays.fill(_bytes, (byte) 'z'); 
            _bytes = null; 
        } 
        super.finalize(); 
    } 
}