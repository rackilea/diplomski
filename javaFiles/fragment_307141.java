public class MyThingie {

TreeMap<Integer, String> data = new TreeMap<Integer, String>();

public void doIt() {
    ...

    insertElement("politics_counter", politics_counter);
    insertElement("economics_counter", economics_counter);
    insertElement("foreign_counter", foreign_counter);
    insertElement("sport_counter", sport_counter);
    insertElement("weather_counter", weather_counter);

    System.out.println("Highest variable is "+data.lastEntry().getValue());
}

public void insertElement(String name, Integer i) {
    if (data.get(i) == null) {
        System.out.println("Element "+name+" has the name value as "+data.get(i));
    }
    else {
        data.put(name,i);
    }
}
}