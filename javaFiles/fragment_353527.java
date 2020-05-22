public class Event {
    String event_id;

    Event(String event_id) {
        this.event_id = event_id;
    }
}

public List<Event> getEvents(String cat, int start, int step)  {

    List<Event> list = new ArrayList<Event>();

    if (cat.equalsIgnoreCase("D")){
        for (int i=0; i<listDog.size(); i++){
            System.out.println("di=" + i + "=" + (String)listDog.get(i));

            list.add( new Event( (String)listDog.get(i) ));
        }
    }
    else {
        for (int i=0; i<listHorse.size(); i++){
            System.out.println("i=" + i + "=" + (String)listHorse.get(i));

            list.add( new Event( (String)listHorse.get(i) ));
        }
    }

    return list;

}