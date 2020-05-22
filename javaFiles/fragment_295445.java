long a = System.nanoTime();
      Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/August_2010_in_sports").get();
      String title = doc.title();
   // System.out.println(doc.html());  // will print whole html code
      System.out.println(title);
      long b = System.nanoTime();
      System.out.println( "Time Taken  "  +    (b - a) / 1000000d);