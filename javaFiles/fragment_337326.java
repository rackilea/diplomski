package test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Example {

    public static final String NAME = Example.class.getSimpleName() + ".class";

    public static void main(String[] args) throws URISyntaxException {
        URL url = Example.class.getResource(NAME);
        long size = new File(url.toURI().getPath()).length();
        System.out.printf("The size of file '%s' is %d bytes\n", NAME, size);
    }

}