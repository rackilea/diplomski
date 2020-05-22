byte[] buff = new byte[2048];
while ((nTmp = is.read(buff)) != -1)
{
     dCount+=ntmp;
     //this logic won't work anymore though
     /*
     if (dCount % 600000000 == 0)
     {
         System.out.println(". ");
     }
     else if (dCount % 20000000 == 0)
     {
         System.out.print(". ");
     }
     */
}