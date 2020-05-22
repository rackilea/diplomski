public class NodeGrid {

    private List<List<String>>  data        = new ArrayList<>();
    private int                 currentRow  = 0;

    public void addData(String dataString) {
        while (data.size() <= currentRow) {
            data.add(new ArrayList<>());
        }
        data.get(currentRow).add(dataString);
    }

    public void newRow() {
        data.add(new ArrayList<>());
        currentRow++;
    }

    public List<List<String>> getData() {
        data.remove(currentRow); // the last row is deleted before retrieving since it will always be empty
        return data;
    }
}