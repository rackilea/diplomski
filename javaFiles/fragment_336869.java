ArrayList<String> wordDulicate = new ArrayList<String>();

        wordDulicate.add("Tom");
        wordDulicate.add("Jones");
        wordDulicate.add("Sam");
        wordDulicate.add("Jamie");
        wordDulicate.add("Robie");
        wordDulicate.add("Helen");
        wordDulicate.add("Tom");
        wordDulicate.add("Troy");
        wordDulicate.add("Mika");
        wordDulicate.add("Tom");

        ArrayList<String> nonDupList = new ArrayList<String>();

        Iterator<String> dupIter = wordDulicate.iterator();
        while(dupIter.hasNext())
        {
        String dupWord = dupIter.next();
        if(nonDupList.contains(dupWord))
        {
            dupIter.remove();
        }else
        {
            nonDupList.add(dupWord);
        }
        }
      System.out.println(nonDupList);