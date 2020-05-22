public class DataModelComparator implements Comparator<DataModel> {

    @Override
    public int compare(DataModel o1, DataModel o2) {
        if (o1.getNumber() < o2.getNumber()) {
            return -1;
        } else if (o1.getNumber() > o2.getNumber()) {
            return 1;
        } else {
            if (o1.getColorNumber() < o2.getColorNumber()) {
                return -1;
            } else if (o1.getColorNumber() > o2.getColorNumber()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}