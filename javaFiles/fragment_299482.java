public class SpaceList {

private ArrayList<SpacePhoto> spaceList = new ArrayList<>();

public void addToList(SpacePhoto spacePhoto) {
    spaceList.add(spacePhoto);
}

public ArrayList<SpacePhoto> getSpaceList() {
    return spaceList;

}