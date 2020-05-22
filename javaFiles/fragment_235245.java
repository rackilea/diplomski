Cart crt=null;
while(rst.next())
{
    System.out.println("CPoint");
    try
    {
        long p = rst.getLong("itemID"); 
        crt.itmID = p; // This is the line thats creating the error
        System.out.println(p + " is long! I guess...");
    }