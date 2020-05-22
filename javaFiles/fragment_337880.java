public static String scanPrint( )
 {
        Scanner stdinSP = new Scanner(System.in);
        String wordSP = null;

        while(true)
        {

            if((wordSP = stdinSP.nextLine().trim()).length() == 0)
            {
                System.out.println("fail");
                break;
            }
            else
            {
                System.out.println("success");
                break;
            }
        }
        System.out.println(wordSP); //debug
        return wordSP;
    }