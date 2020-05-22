import java.util.ArrayList;
import java.util.List;

public class TestClass {

    static List<SomeObject> flatList = new ArrayList<SomeObject>();

    public static void flatten(SomeObject object) {
        if (object != null ){
            if( object.getObjects() != null && !object.getObjects().isEmpty()) {
            for (SomeObject o : object.getObjects()) {
               flatten(o);
               flatList.add(object);
            }           
        }
        }
    }

    public static void main(String[] args) {

        SomeObject o1 = new SomeObject("1");

        SomeObject o2 = new SomeObject("2");

        SomeObject o3 = new SomeObject("3");

        SomeObject o4 = new SomeObject("4");

        o1.addObject(o2);
        o2.addObject(o3);
        o3.addObject(o4);

        flatten(o1);
        for (SomeObject obj : flatList){
            System.out.println(obj.getObjectName());
        }


    }

}

 class SomeObject {

     String objectName = "";

     public SomeObject(String name) {
        this.objectName = name;
    }
      private List<SomeObject> objects = new ArrayList<SomeObject>();

    public List<SomeObject> getObjects() {
        return objects;
    }

    public void setObjects(List<SomeObject> objects) {
        this.objects = objects;
    }

    public void addObject(SomeObject o){
        objects.add(o);     
    }

    public String getObjectName() {
        return objectName;
    }
}