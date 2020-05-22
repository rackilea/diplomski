public class Main {

    public static void main(String[] args){
        MyMap<People, Information> map = new MyMap<>();
        People p = new People();
        Information i = new Information();
        map.add(p, i);
    }
}