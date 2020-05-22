int lower = Math.max(myPair1.x1, myPair2.x1);
int upper = Math.min(myPair1.x2, myPair2.x2);

if(lower < upper)
  return new Pair(lower, upper)
else 
  throw new CustomException("Intervals not overlap")