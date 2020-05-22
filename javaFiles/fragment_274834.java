public class Booking extends Observable {
    private String authorKey; //authorKey for the booking
    // private ArrayList<Observer> observers; //users registered for the room (no need because Observable holds a list of Observer already)

    public Booking(String authorKey){
        this.authorKey = authorKey;
    }   


public void refreshAccess(){
    nofityObservers(null);
}

public void refreshAccess(String newAuthorKey){
    String oldAuthorKey = this.authorKey;
    this.authorKey = newAuthorKey;
    nofityObservers(oldAuthorKey);
}

@Override
public void notifyObservers(Object arg) {
    setChanged();
    super.notifyObservers(arg);
}
}

public class User implements java.util.Observer {
private ArrayList<String> authorKeys; // to get all bookings a user has

public User(){
}

public void addBooking(Booking b) {
    b.addObserver(this);
}

@Override
public void update(Observable o, Object arg) {
    if (!(o instanceof Booking ))
        return;
    Booking b = (Booking) o;
    if(arg != null) 
        authorKeys.remove(arg);
    authorKeys.add(b.getAuthorKey());
}
}