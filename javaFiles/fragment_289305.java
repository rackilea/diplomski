List<List<Dico>> sublists = new ArrayList<>(change);

for (int i = 0; i < change; i++)
{ 
   sublists.add(list.subList(changes[i],changes[i + 1]));
}