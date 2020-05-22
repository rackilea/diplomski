public void anyMethod()
{
    Integer count=callCount.get("anyMethod"); 

    if(count==null)
    {
        count= new Integer(0);
    }

    count++;
    callCount.put("anyMethod",count);

    /**
    other things that your method do......
    **/
}