public class Group {

    private String Name;
    private String Detail; // Add a new Detail member

    private ArrayList<Child> Items;

    public String getName() {
        return Name;
    }

    public String getDetail() {
        return Detail; // change getter
    }

    public void setDetail(String Detail) {
        this.Detail = Detail; // change setter
    }

    public void setName(String name) {
        this.Name = name;
    }

    ...
}