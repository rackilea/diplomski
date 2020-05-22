public class IteratorAction extends ActionSupport{

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setlist(List<String> list) {
        this.list= list;
    }

    public String execute() {

        list= new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        return SUCCESS;
    }
}