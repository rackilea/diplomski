List<List<String>> container;

     for (int i = 0; i < count; i++) 
      {
        int  len = arr.get(i).length();
        String[] s = arr.get(i).toString().split("\\|");
        List<String> wordList = Arrays.asList(s);
        container.add(wordList);
       }