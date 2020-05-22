import java.util.*;
import java.util.stream.*;

public class Test {

    private class DataItem {
        public int wordID, categoryID, documentID, count;

        public DataItem(int w, int c, int d) {
            wordID = w;
            categoryID = c;
            documentID = d;
        }

        public String toString() {
            return "wordID:" + wordID + " categoryID:" + categoryID + " documentID:" + documentID;
        }
    }

    private Map<Integer, DataItem> map;

    public void setList(List<DataItem> list) {
        this.map = list.stream().collect(Collectors.toMap(dataItem -> dataItem.wordID * dataItem.categoryID * dataItem.documentID, dataItem -> dataItem));        
    }

    public DataItem getDataItem(int wordID, int categoryID, int documentID) {
        return map.get(wordID * categoryID * documentID);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.setList(Arrays.asList(t.new DataItem(1,2,3), t.new DataItem(2,3,4), t.new DataItem(3,3,4)));
        System.out.println(t.getDataItem(2,3,4));
    }
}