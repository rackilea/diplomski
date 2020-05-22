import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String birthday;
    private String dateOfVisit;

    public Person(String data) {
        String[] info = data.split(",");
        name = info[0];
        age = Integer.parseInt(info[1]);
        birthday = info[2];
        dateOfVisit = info[3];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public String toString() {
        return String.format("%s %d %s ", name, age, birthday);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        File myFile = new File("C:\\Windows\\Temp\\fileName.csv");
        Person lastPerson = null;
        int count = 0;
        try (Scanner myScanner = new Scanner(myFile)) {
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                Person p = new Person(data);
                if (lastPerson == null  ||  !lastPerson.getName().equals(p.getName())) {
                    if (count == 1) {
                        System.out.println(lastPerson.getDateOfVisit());
                    }
                    System.out.print(p);
                    count = 1;
                    lastPerson = p;
                }
                else {
                    if (count == 1) {
                        System.out.println();
                        System.out.println(lastPerson.getDateOfVisit());
                    }
                    count++;
                    System.out.println(p.getDateOfVisit());
                }
            }
            // Print the visit date of the last person in the CSV file.
            if (count == 1) {
                System.out.println(lastPerson.getDateOfVisit());
            }
        }
        catch (IOException xIo) {
            xIo.printStackTrace();
        }
    }
}