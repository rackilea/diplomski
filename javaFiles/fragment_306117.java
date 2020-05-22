public static void enterString(String value)
    {   
        String Keyvalue=value.toUpperCase();
        //System.out.println(Keyvalue);
        for (int i=0;i<Keyvalue.length();i++)
        {
            //System.out.println(Keyvalue.charAt(i));
            if(Keyvalue.charAt(i) == ':')
            {
                System.out.println("its a colon");
                RoboKey.keyPress(KeyEvent.VK_SHIFT);
                RoboKey.keyPress(KeyEvent.VK_SEMICOLON);
                RoboKey.keyRelease(KeyEvent.VK_SEMICOLON);
                RoboKey.keyRelease(KeyEvent.VK_SHIFT);

            }
            else if (Keyvalue.charAt(i) == '.')
            {
                RoboKey.keyPress(KeyEvent.VK_PERIOD);
            }
            else if (Keyvalue.charAt(i) == '_')
            {
               RoboKey.keyPress(KeyEvent.VK_SHIFT);
               RoboKey.keyPress(KeyEvent.VK_MINUS);
               RoboKey.keyRelease(KeyEvent.VK_MINUS);
               RoboKey.keyRelease(KeyEvent.VK_SHIFT);
            }
            else
            {
               RoboKey.keyPress((int)Keyvalue.charAt(i));
            }
        }
    }