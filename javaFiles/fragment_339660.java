abc:
    {
        try
        {
            a();
            break abc;
        }
        catch(Exception e){}

        try
        {
            b();
            break abc;
        }
        catch(Exception e){}

        try
        {
            c();
            break abc;
        }
        catch(Exception e){}

    }