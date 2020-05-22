public Set<Integer> findDuplicates(List<MyObject> listContainingDuplicates)
{ 
  // Assuming your ID is of type int
  final Set<Integer> setToReturn = new HashSet(); 
  final Set<Integer> set1 = new HashSet();

  for (MyObject object : listContainingDuplicates)
  {
   if (!set1.add(object.getID()))
   {
    setToReturn.add(object.getID());
   }
  }
  return setToReturn;
}