public class Player
{
    private SimpleStringProperty name;

    public Player(String name)
    {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
}