for (int x = 0; list.size(); x++)
{
  obj = list.get(x);
  if (obj.isExpired())
  {
    list.remove(obj);
    // Oops! list.get(x) now points to some other object so if I 
    // increase x again before checking that object I will have 
    // skipped one item in the list
  }
}