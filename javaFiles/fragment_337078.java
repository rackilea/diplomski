boolean idFound = false;
for(int arrayID : a)
{
  if (arrayID == id)
  {
    idFound=true;
    // found id in the array ... do your logic here
  }
}
if (!idFound)
{
  // ID not found...ask about new id
}