public static void processLine(File input, File output) throws FileNotFoundException{ 
        Scanner i = new Scanner(input);
        PrintStream o = new PrintStream(output);

        ArrayList<String> saved= new ArrayList<String>();

        while(i.hasNextLine()){
            String text = i.nextLine();      
            char[] pos = new char[text.length()];
            for (int x = 0; x < text.length();x++){
                pos[x] = text.charAt(x);
            }

            saved.add(text);
        }


        // you can use "saved" here ! :) but this code can be shorter I think
    }