public static class PBEWithSHA
    extends PBEKeyFactory
{
    public PBEWithSHA()
    {
        super("PBEwithHmacSHA", null, false, PKCS12, SHA1, 160, 0);
    }
}