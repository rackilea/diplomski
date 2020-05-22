int power(int n, int p) throws Exception {
    try
    {
        return (int)Math.pow(n,p);
    }
    catch(Exception e)
    {
        throw new Exception("n and p should be non-negative");
    }
}