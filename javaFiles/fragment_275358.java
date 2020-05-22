while (iterator.hasNext()) {
    Document doc = iterator.next();
    String name = doc.getString("name");
    int age = doc.getInteger("age");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
}