private native void destroyNativeInstance( long p_internalPtr );

public void finalize()
{
    destroyNativeInstance( this.internalPtr );
}