public class Test {

public static void main(String[] args){



try {
System.out.println(new URL("http://www.ietf.org/rfc/rfc2396.txt").getDefaultPort());

System.out.println(new URL("ftp://www.ietf.org/rfc/rfc2396.txt").getDefaultPort());


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}