public class test {

    private static HashMap<String, String> test= new HashMap<String, String>();

    public void settest(String key, String value) {
        test.put(key, value);
    }

    public String gettest(String key) {
        return test.get(key);       
    }

}

public class b{
    test ts=new test();
    ts.settest("location","Chicago");
}


public class c{
    test ts=new test();
    System.out.println(ts.gettest("location"));
}