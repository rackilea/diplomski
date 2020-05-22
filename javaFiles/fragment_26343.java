// Not tested, but it should give you the right idea.
Collections.sort(myList);  // you may need to use a comparator here if your objects don't implement Comparable
int rank = 0;
int lastVotes = -1;
for (MyObject o : list)
{
  if (o.getVotes() != lastVotes)
  {
    rank += 1;
  }
  myMap.put(o, rank);
  lastVotes = o.getVotes();
}