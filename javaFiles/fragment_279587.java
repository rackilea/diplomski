while (urls.hasMoreTokens()) {
    try {
       word.set(urls.nextToken());
       String currenturl = word.toString();
       System.out.println(currenturl);
       pile.getQueue().add(currenturl);