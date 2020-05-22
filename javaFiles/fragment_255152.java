public class MyClass{
    private final List<String> myList = new ArrayList<String>();

    public List<String> getList(){
        return Collections.unmodifiableList(this.myList);
    }

    public void addToList(final String s){
        this.myList.add(s);
    }
}