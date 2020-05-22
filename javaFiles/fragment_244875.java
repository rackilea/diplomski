static <E> ArrayList combine(ArrayList<E> soFar, ArrayList<E>... lists)
{
    // Rather than constantly making and remaking this list could just use one
    // and pass it around and add stuff to it. This works though.
    ArrayList<ArrayList<E>> combs=new ArrayList<ArrayList<E>>();

    // Loop through the first list looking for elements
    for(E e:lists[0])
    {
       // Create a new List to build this combination
       ArrayList<E> temp = new ArrayList<>(soFar);
       // Add this element to the combination
       temp.add(e);
       // If there are more lists recurse down
       if (lists.length > 1) {
           // Use recursion to add all combinations of the remaining lists
           combs.addAll(combine(temp, lists.subList(1)));
       } else {
           // There are no more lists so we are done, add temp to the combos
           combs.add(temp);
       }
    }
    return combs;
}


// Call this method to start things going, the other one should probably be private
static <E> ArrayList combine(ArrayList<E>... lists)
    return combine(new ArrayList<E>(), lists);
}