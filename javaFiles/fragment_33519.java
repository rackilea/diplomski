......
public static void main(String[] args) throws ClassNotFoundException {

List<MyObject> list= new ArrayList<MyObject>();
        list.add(new MyObject());
        System.out.println("the type of the list is: "+classTypeOfList(list));
}

public static <T> String classTypeOfList(List<T> list) throws ClassNotFoundException {
        return list.get(0).getClass().getCanonicalName(); 
}