public static int getGraphemeCount(String text) {
      int graphemeCount = 0;
      BreakIterator graphemeCounter = BreakIterator.getCharacterInstance();
      graphemeCounter.setText(text);
      while (graphemeCounter.next() != BreakIterator.DONE) 
          graphemeCount++;
      return graphemeCount;
  }