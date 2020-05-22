public class UrlTest {

    static public void urltest(String s) {
        long start = System.currentTimeMillis();
        try {
            new URL(s);
            System.out.println("successfully created URL after "+(System.currentTimeMillis()-start)+" milliseconds. URL: "+s);
        } catch(Exception e) {
            System.out.println(e.toString()+" after "+(System.currentTimeMillis()-start)+" milliseconds. URL: "+s);         
        }
    }

    static public void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        urltest(null);
        urltest("://");
        urltest("/abc");

    }
}