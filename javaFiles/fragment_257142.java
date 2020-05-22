public class MyEntity {

    @Column
    private long createdOn;

    public Date getCreatedOn() {
        return new Date(createdOn);
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn.getTime();
    }

}