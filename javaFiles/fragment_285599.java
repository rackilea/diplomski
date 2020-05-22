ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream("1"));
    ... write objects
    o1.close();
    ObjectOutputStream o2 = new AppendingObjectOutputStream(new FileOutputStream("1", true));
    ... append objects
    o2.close();