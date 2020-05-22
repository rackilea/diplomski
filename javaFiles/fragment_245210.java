Set<String> words = new HashSet<String>();
      while ((fileScanner.hasNext())) { 
               words.add(fileScanner.next());
      }
      System.out.println("There are " +  words.size() + " unique word(s)");
      System.out.println("These words are:");
      //System.out.println(words.toString());
      for (Iterator<String> it = words.iterator(); it.hasNext(); ) {
          String f = it.next();
          System.out.println(f);
      }
      fileScanner.close();