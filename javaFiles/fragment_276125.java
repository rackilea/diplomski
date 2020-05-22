public class Main {

    public static <T> void main(String[] args) throws Exception {
        SmartTable<T>.Column column = new SmartTable<T>().new Column();
        Comparator<T> comparator = ((SmartTable.ComparableColumn) column).comparator;

    }

    static class SmartTable<T> {
        class Column {

        }
        class ComparableColumn extends Column {
            Comparator<T> comparator;
        }
    }

}