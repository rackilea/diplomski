public static <T> FastList<T> distinct(
        FastList<T> fastList, 
        HashingStrategy<T> hashingStrategy)
{
  MutableSet<T> seenSoFar = 
          UnifiedSetWithHashingStrategy.newSet(hashingStrategy);
  FastList<T> targetCollection = FastList.newList();
  for (int i = 0; i < fastList.size(); i++)
  {
    if (seenSoFar.add(fastList.get(i)))
    {
      targetCollection.add(fastList.get(i));
    }
  }
  return targetCollection;
}