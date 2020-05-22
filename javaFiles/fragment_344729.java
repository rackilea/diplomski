list l = new list();
item a;
l.add(a);
item b = l.get(0);
b.property = 10;
l.get(0).property == 10; //true, a is the same object as b
b = new item();
l.get(0) == b; //false, list[0] is still a, b is now pointing to a different object
l.get(0) = b; //error, you can't assign to list.get