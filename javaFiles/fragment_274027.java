public class MainActivity extends AppCompatActivity {

    ...

    public static Map<String, String> getTheMap() {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("FooKey", "FooVal");
        map.put("BarKey", "BarVal");
        return map;
    }

    ...

    public native void convertMap();
}