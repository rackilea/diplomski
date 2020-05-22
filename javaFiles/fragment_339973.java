public class BookList{
    List <String> list;

    public BookList(boolean flag) {
        if(flag) {
            list = new ArrayList<>();
        } else {
            list = new LinkedList<>();
        }
    }
}