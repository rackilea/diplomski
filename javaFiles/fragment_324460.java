Person p = new Person();
p.name = "Foobar";
p.age = 42;

ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/test.txt"));
oos.writeObject(p);
oos.close();