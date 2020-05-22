4. for (Iterator iterator2 = mylist.iterator(); iterator2.hasNext();)
{
    String string = (String) iterator2.next();
    System.out.println(string);
    iterator2.remove(); //It worked but if I used the same thing to remove element from original list it threw exception.
}