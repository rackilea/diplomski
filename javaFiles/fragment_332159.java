File file = new File("file.txt");
    Scanner in;
    try {
        in = new Scanner(file);

        while (in.hasNextLine())
        {
           String MyLine = in.nextLine();
            if(MyLine.equals( "W") || MyLine.equals( "O") || MyLine.equals(  "P"))
            {
                System.out.println(MyLine);
            }
        }


        in.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }