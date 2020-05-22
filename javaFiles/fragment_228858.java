public abstract class BaseClass<T>{

    protected abstract void insertItem(T object, String table);

    protected void insertAllItemsToDb(List<T> items, String table) {
        //...
        for (T object : items) {
            insertItem(object, table);
        }
        //...
    }

}