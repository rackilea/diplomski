List<Integer> list = new ArrayList<Integer>();
int MAX_ELEMENTS = 5; //Set this to however you want to constrain the datatype

public boolean addElement(Integer value) {
   if (list.size() < MAX_ELEMENTS) {
     list.add(value);
     return true;
   } else {
     return false;
   }
}

public boolean isFull() {
  return (list.size() == MAX_ELEMENTS);
}

public Integer getLast() {
  if (!list.isEmpty())
    return list.get(list.size()-1);
  else
    return null;
}