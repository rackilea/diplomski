public class Test<T>  {
    List<T> list = new ArrayList<T>();
    public Test(){

    }
    public void populate(T t){
        list.add(t);
    }
    public static  void main(String[] args) {
        new Test<String>().populate("abc");
    }
}