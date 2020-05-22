// each cell here is for a cell at the same offset in the
// hash table
int numValidWhenFirstSetValid[SIZE];
int numValidSoFar = 0; // initialise only this
// Only cells 0..numValidSoFar-1 here are valid.
int validOffsetsInOrderSeen[SIZE];

boolean isValid(int offsetInArray)
{
  int supposedWhenFirstValid =
   numValidWhenFirstSetValid[offsetInArray]
  if supposedWhenFirstValid >= numValidSoFar)
  {
    return false;
  }
  if supposedWhenFirstValid < 0)
  {
    return false;
  }
  if (validOffsetsInOrderSeen[supposedWhenFirstValid] !=
    offsetInArray)
  {
    return false;
 }
 return true;
}