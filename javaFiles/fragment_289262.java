Iterator<Date> iterator = schedule[i].occurenceIterator();
Date tmp;
while (iterator.hasNext()) {
   tmp = iterator.next();
   if (tmp.compareTo(date) == 0) {
      System.out.println(tmp.toString());
   }
}