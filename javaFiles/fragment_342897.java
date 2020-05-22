Boolean mainCondition;
if (getNo() != null) {
  mainCondition = !compareNo(getNo(), b.getNo());
} else {
  mainCondition = getNo() != null;
}
if (mainCondition) 
{
  return 100;
}