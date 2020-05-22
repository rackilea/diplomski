Set<Object> originalSet = somemethod();

//Keep track of items we've already processed
Set<Object> processed = new HashSet<Object>();

//toDo is used to calculate which items in originalSet aren't in processed
Set<Object> toDo = new HashSet(originalSet);
toDo.removeAll(processed);

while (! toDo.isEmpty()) {
  //Get an object from toDo
  Object item = toDo.iterator().next();

  //Do some processing
  //Can update originalSet or even remove from processed if we want to re-do an item

  //Recalculate what's left to do
  processed.add(item);
  toDo = new HashSet(originalSet);
  toDo.removeAll(processed);
}