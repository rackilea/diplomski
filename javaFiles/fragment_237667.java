List<Element> iteration1 = Arrays.asList(
        new Element(5),
        new Element(4),
        new Element(3),
        new Element(2),
        new Element(1)
);
System.out.println(iteration1);
List<Element> iteration2 = getTheNewList(iteration1);
System.out.println(iteration2);
List<Element> iteration3 = getTheNewList(iteration2);
System.out.println(iteration3);