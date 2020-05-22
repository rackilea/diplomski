public class MyList {
    List<String>  list;
    public MyList(Srting parameter) {
        list = new ArrayList<String>(parameter.split(","));    
    }

    public List<String> getList() {
        return list;   
    }
}