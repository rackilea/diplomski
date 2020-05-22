int counterWithoutSpace = 0, counterWithSpace = 0;

         while (in.hasNextLine())
         {
            String line = in.nextLine();

            Scanner inLine = new Scanner(line);
            while (inLine.hasNext())
            {
               String nextWord = inLine.next();
               counterWithoutSpace += nextWord.length();
               counterWithSpace += nextWord.length() + 1;
            }
            counterWithSpace--;
         }