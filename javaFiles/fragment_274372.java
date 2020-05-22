public class PrivateData
{
    public Object publicInput_;
    private ByteBuffer privateInputBuffer_;

    public PrivateData(Object publicInput, Object privateInput)
    {
       publicInput_ = publicInput;
       privateInputBuffer_ = encrypt(privateInput_);
    }

    Object getPrivateInfo()
    {
       return decrypt(privateInputBuffer_);
    }
}