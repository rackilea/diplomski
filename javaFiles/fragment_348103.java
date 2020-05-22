public static void main(String [] arg)
{
    // print out your initial information first (i.e. your column headers)
    // ...

    List sortedList = new List();
    String word = nextWord();

    // now, the question is... what is the end condition of the loop?
    // probably that there aren't any more words, so word in this case
    // will be null
    while (word != null)
    {
      sortedList.insert(word);
      word = nextWord();
    }

    // now, your list takes care of the sorting, so let's just print the list
    sortedList.printWords();
}