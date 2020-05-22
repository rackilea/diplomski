for(PirateDictionary w: words){

    nameSearch = w.toString();
    Iterator<Phrase> it = phrases.iterator();
    boolean found = false;

    while(it.hasNext() && !found) {

       Phrase c = it.next();

       if (c.getName().equals(nameSearch))  {
           System.out.println( c.getName());
           found = true;
       }
    }

    if (!found)
        System.out.println(w.toString());
}