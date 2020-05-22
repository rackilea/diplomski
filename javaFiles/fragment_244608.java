public class ParseMyData<T extends DataProvider> {

    T classOneOrClassTwo;

    ParseMyData(T t) {
        classOneOrClassTwo = t;
    }

    public void parseIt() {
        classOneOrClassTwo.getData();
    }