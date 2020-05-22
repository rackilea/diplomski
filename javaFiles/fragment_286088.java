import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClassWrapperDemo {
    public static void main(String[] args) throws Exception {
        MyClassWrapper<MyClass> wrapper=
                new MyClassWrapper<MyClass>(
                MyClass.class, 
                new String[]{"firstparam", "secondparam", "thirdparam" },
                new Class<?>[]{String.class, Date.class, Integer.class}
                );     
        Map<String, Object> params =new HashMap<String, Object>();
        params.put("firstparam", "HelloWorld");
        params.put("secondparam", new Date());
        params.put("thirdparam", 30);
        wrapper.addEntry(params);
        List<MyClass> list= wrapper.getEntries();
        String[] lebels = wrapper.getColumnLabels();
        Class<?>[]  objects= wrapper.getColumnClasses();
        System.out.println(list);
        System.out.println(Arrays.toString(lebels));
        System.out.println(Arrays.toString(objects));

    }

}