class Test
{
    static int getNumber(String val)
    {
        return Integer.parseInt(val.split("-")[1]);
    }

    public static void main (String[] args)
    {
        String[] vals = {"A-1111","B-2222","C-3333"};
        for(String val:vals)
        {
            System.out.println("Numeric part in [" + val + "] is : " + getNumber(val));
        }
    }
}