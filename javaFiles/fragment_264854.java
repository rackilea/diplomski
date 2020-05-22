public static List<Time> swap(Time x, Time y){

    Time temp = new Time(300);
    System.out.println("Before x is " + x.uniqueObjId);
    System.out.println("Before y is " + y.uniqueObjId);
    System.out.println("Before temp is " + temp.uniqueObjId);

    x = x.getObj();
    y = y.getObj();
    temp = x;
    x = y;
    y = temp;
    List<Time> list = new ArrayList<Time>();
    list.add(x);
    list.add(y);
    System.out.println("After x objectId is " + x.uniqueObjId);
    System.out.println("After y objectId is " + y.uniqueObjId);
    System.out.println("After temp objectId is " + temp.uniqueObjId);
    return(list);
}