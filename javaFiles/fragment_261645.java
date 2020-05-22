...
{
   String ftp = "ftp://user:pword@sysc/u/Xxxxxxxxxx/ICS/YT7/XxxxxXxxxxxxx/xxxxxxxxx/logs/xxxxxxxx/XX_YT.LOG";    
   try
   {
       URL.setURLStreamHandlerFactory(new ApacheURLStreamHandlerFactory()); 
    ...