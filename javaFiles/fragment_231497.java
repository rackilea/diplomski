class C
{
    private boolean mBoo; //that's our variable

    public interface BooChangeListener
    {
        public void OnBooChange(boolean Boo);
    }

    private BooChangeListener mOnChange = null;

    public void setOnBooChangeListener(BooChangeListener bcl)
    {
        mOnChange = bcl;
    }
}