public Root()
{
    while (true) {
        try{
            for(int y=0;y<System.in.available();++y)
            {
                try 
                {
                    System.out.print((char)System.in.read());
                } 
                catch (IOException exep)
                {
                    System.out.print(exep.getLocalizedMessage());
                }
            }
        }
        catch(IOException exep)
        {
            System.out.println(exep.getLocalizedMessage());
        }
    }
}