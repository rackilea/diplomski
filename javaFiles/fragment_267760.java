import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Example{
    public static void main(String[] args) {
        MyObject obj = new MyObject("Kevin");
        MyObject obj1 = new MyObject("Chris");
        MyObject obj2 = new MyObject("Oliver");
        MyObject obj3 = new MyObject("Jack");
        MyObject obj4 = new MyObject("Joe");

        Set<MyObject> set = new HashSet<MyObject>();
        Set<MyObject> set1 = new HashSet<MyObject>();
        Set<MyObject> set2 = new HashSet<MyObject>();
        Set<MyObject> set3 = new HashSet<MyObject>();
        Set<MyObject> set4 = new HashSet<MyObject>();

        set.add(obj);
        set1.add(obj1);
        set2.add(obj2);
        set3.add(obj3);
        set4.add(obj4);

        Map<String,Set<MyObject>> map = new HashMap<String,Set<MyObject>>();
        map.put("s", set);
        map.put("s1", set1);
        map.put("s2", set2);
        map.put("s3", set3);
        map.put("s4", set4);

        MyObject found = search(map, "Jack");
        System.out.println(found.name);
    }

    private static MyObject search(Map<String, Set<MyObject>> map, String string) {
        for(Set<MyObject> s: map.values()){
            for(MyObject mObj:s){
                if(mObj.name.equals(string)){
                    return mObj;
                }
            }
        }
        return null;        
    }

}

class MyObject{
    String name;

    public MyObject(String name){
        this.name = name;
    }
}