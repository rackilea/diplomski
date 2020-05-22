import java.util.ArrayList;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");  

        ArrayList<Contact> list = new ArrayList<>();
        list.add(new Contact());
        list.add(new Contact());
        list.add(new Contact());
        list.add(new Contact());
        list.add(new Contact());

        try {
                File file = new File("output.txt");
                PrintWriter p = new PrintWriter(file);

                int count = list.size();

                for (int i = 0; i < count; i++) {
                    Contact temp = list.get(i);
                    p.println(temp.getFavColour() + ";" + temp.getSurname() + ";" + temp.getName() + ";");
                }
                p.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Contact {
        public String getName() {
            return "John";
        }

        public String getSurname() {
            return "Black";
        }

        public String getFavColour() {
            return "red";
        }
    }
}