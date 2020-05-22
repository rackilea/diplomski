public interface SnapshotListener{
    void onListFilled(ArrayList<String> arrayLat);
    void onFailure();
}
    public void getLat(int i, SnapshotListener listener) {
            fillDriverList(listener);
            //arrayLat.get(i);
            //return"0.000";

        }