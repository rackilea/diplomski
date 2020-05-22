Iterator<Map.Entry <Character, Integer> > it = keyStates.entrySet().iterator();
  while (it.hasNext()) {
      Map.Entry<Character, Integer> pair = it.next();
      Integer newCount = (pair.getValue() == null) ? 1 : pair.getValue() + 1 ;
      pair.setValue(newCount);
  }