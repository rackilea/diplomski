import java.io.*;
import java.util.*;

class Test{
    public static void main(String [] args) throws Exception {
        Properties props = new Properties();
        props.load(new StringReader("password="));
        System.out.println(props.size()); // 1
        System.out.println(props.getProperty("password").length()); // 0
    }
}