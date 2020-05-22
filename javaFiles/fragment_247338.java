public class VacuumCleaner
    /**
     * The house that this vacuum cleaner cleans 
     */
    private House house;

    public VacuumCleaner(House houseToClean) {
        this.house = houseToClean;
    }

    public boolean isRoomDirty(int roomId) {
        // find the room in the house, and see if it contains dirt
    }

    public void cleanRoom(int roomId) {
        // find the room in the house, and remove dirt from it
    }
}