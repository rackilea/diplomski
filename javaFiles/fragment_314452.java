Person name = new Person();
name.addPerson("Peter",10);
System.out.println("Peter " + name.getMap().get("Peter") + " points");

Person name2 = new Person();
Help help = new Help();
help.addPersonDifferentMethod(name2);
System.out.println("Peter " + name2.getMap().get("Peter") + " points");