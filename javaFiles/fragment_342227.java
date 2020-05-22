Iterator iter1 = list1.iterator();
Iterator iter2 = list2.iterator();
while (iter1.hasNext() && iter2.hasNext()){
    Item a = iter1.next();
    Item b = iter2.next();
    doSomething(a, b);
}