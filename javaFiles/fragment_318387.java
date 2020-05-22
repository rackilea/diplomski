import java.util.*;
import java.io.*;
import java.net.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> addresses = new ArrayList<String>();
        addresses.add("http://foo.com/?animal=monkey&banana=fruit%20%26%20delicious");
        addresses.add("http://foo.com/?animal=monkey&banana=fruit %26 delicious");
        addresses.add("http://foo.com/?animal=monkey&banana=fruit & delicious");
        //addresses.add("http://foo.com/?animal=monkey&banana=fruit \%26 delicious"); this uses an illegal escape character

        for (String address : addresses) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try {
                URL url = new URL(address);
                URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
                URL urlA = uri.toURL();
                System.out.println("address: " + address);
                System.out.println("yields: ");
                System.out.println("  * urlA: " + urlA);
                uri = new URI(address);
                URL urlB = uri.toURL();
                System.out.println("  * urlB: " + urlB);
            } catch (Exception e) {
                System.out.println("  Problem!");
            }
        }
    }

}