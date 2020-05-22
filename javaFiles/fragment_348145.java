public class DateSorter {

public static void main(String[] args) {

    List<MyObject> myObjects = new ArrayList<MyObject>();

    Calendar cal = new GregorianCalendar();
    cal.set(2015, 4, 24, 14, 00);
    Date dt1 = cal.getTime();

    cal = new GregorianCalendar();
    cal.set(2015, 4, 24, 9, 00);
    Date dt2 = cal.getTime();

    cal = new GregorianCalendar();
    cal.set(2015, 4, 25, 15, 00);
    Date dt3 = cal.getTime();

    myObjects.add(new MyObject("1", dt1));
    myObjects.add(new MyObject("2", dt2));
    myObjects.add(new MyObject("3", dt3));

    Collections.sort(myObjects, new Comparator<MyObject>() {
        @Override
        public int compare(MyObject object1, MyObject object2) {
            return (int) (object1.getDate().compareTo(object2.getDate()));
        }
    });

    System.out.println(myObjects.get(0));
    System.out.println(myObjects.get(1));
    System.out.println(myObjects.get(2));

}

}