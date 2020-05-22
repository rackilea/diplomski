public class Door {
    private boolean locked;
    private boolean open;

    public boolean openDoor() {
        if (locked || open) {
            return false; //You can't open a locked or already open door
        }
        open = true;
        return true;
    }
}