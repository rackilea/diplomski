User u = new User("abc");
Dog d1 = new Dog("D1");
Dog d2 = new Dog("D2");
u.addDog(d1);
u.addDog(d2);
System.out.println(u + " ownes " + u.getOwnedDogs());
System.out.print(d1 + " is owned by " + d1.ownerAsString());