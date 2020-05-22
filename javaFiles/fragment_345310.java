public class User {

    private StringProperty nick = new SimpleStringProperty();
    private StringProperty text = new SimpleStringProperty();
    private ObjectProperty<Date> time = new SimpleObjectProperty<Date>();

    public StringProperty nickProperty(){ return nick;}
    public StringProperty textProperty(){ return text;}
    public ObjectProperty<Date> timeProperty(){ return time;}

    public User(String nick, String text, Date time){

        this.nick.set(nick);
        this.text.set(text);
        this.time.set(time);
    }
}