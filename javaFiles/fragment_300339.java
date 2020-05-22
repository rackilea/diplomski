try
        {
            Integer.parseInt(inputString);
            //No exception thrown, this is a valid Integer!
        }
        catch(NumberFormatException e)
        {
            //NumberFormatException! "inputString" Can not be an Integer!
        }