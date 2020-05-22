PostMethod post = new PostMethod("yourUrl")
{
    @Override
    public boolean getFollowRedirects()
    {
        return true;
    }
};