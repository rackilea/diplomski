List<Character> arr = new ArrayList<Character>();

         while (in.hasNextLine())
         {
            String line = in.nextLine();

            for (char c : line.toCharArray())
            {
               arr.add(c);
            }
         }