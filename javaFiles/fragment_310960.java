itrA = a.iterator();
itrB = b.iterator(); 

while (itrA.hasNext() || itrB.hasNext()) {
  if (itrA.hasNext())
      newList.add(itrA.next());
  if (itrB.hasNext())
      newList.add(itrB.next());
}