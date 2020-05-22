public class struttura {

    private int _facetCount;

    public long nativeVectorTarget;

    public struttura(int facetCount)
    {
        _facetCount = facetCount;
    }

    public int getFacetCount()
    {
        return _facetCount;
    }

    private void setTarget(long nativePointer)
    {
        nativeVectorTarget = nativePointer;

    }
}