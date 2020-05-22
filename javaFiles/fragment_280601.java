public class HostelWrapper {
    private Hostel hostel;
    private int owner_id;
    private String owner_firstName;
    private String owner_lastName;

    public HostelWrapper() {
        hostel = new Hostel();
    }

    public Hostel getHostel() {
        return hostel;
    }
    public void setId(int id) {
        hostel.setId(id);
    }
    public void setOwner(User owner) {
        hostel.setOwner(owner);
    }
    // other setters for Hostel fields ...

    public int getOwner_id() {
        return owner_id;
    }
    public void setOwner_id(Integer owner_id) {
    // beware : may be null because of outer join
        this.owner_id = (owner_id == null) ? 0 : owner_id;
    }
    //getters and setters for firstName and lastName ...
}