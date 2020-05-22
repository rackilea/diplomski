import java.util.ArrayList;

public class ListHolder<T> {
    public ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();

    public int size() {
        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            size += list.get(i).size();
        }
        return size;
    }

    public T get(int i) {
        if (i >= size())
            return null;

        int listIndex = 0;
        int valueIndex = i;

        while (valueIndex >= list.get(listIndex).size()) {
            valueIndex -= list.get(listIndex++).size();
        }

        return list.get(listIndex).get(valueIndex);
    }
}