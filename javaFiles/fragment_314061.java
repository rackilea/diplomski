List<Integer> retainedAtEnd(List<Integer> numbers) {
  int removeX, baseQty, retainedQty, basePos, retainedPos;
  removeX = 1;
  baseQty = numbers.size();
  while(removeX <= baseQty)
  {
    removeX++;
    basePos = numbers.size();
    retainedPos = basePos;
    retainedQty = 0;
    for(int checkPos = baseQty; checkPos >= 1; checkPos--)
    {
      if(0 != checkPos%removeX) 
      {
        basePos = numbers.size()-baseQty+checkPos;
        numbers.set(retainedPos-1, numbers.get(basePos-1));
        retainedPos--;
        retainedQty++;
      }
    }
    baseQty = retainedQty;
  }
  return numbers.subList(numbers.size()-baseQty, numbers.size());
  // return new ArrayList(numbers.subList(numbers.size()-baseQty, numbers.size()));
}