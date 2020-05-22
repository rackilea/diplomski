import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;

import java.util.Scanner;

import java.util.List;

public class AddNewMember {

    private FileWriter x;
    private Formatter form;
    private Scanner reader;

    public AddNewMember(Scanner reader) {
        this.reader = reader;
    }

    public void openFile() {
        try {
            x = new FileWriter("/Users/askeladd/Downloads/animals.dat", true);
            form = new Formatter(x);
        } catch (Exception e) {
            System.out.println("You have an error");
        }
    }

    public void addRecords() {      
        //Adding Animal Name.
        System.out.println("Please input animal name: ");
        String animal_name = reader.next();
        //Adding Animal's Owner.
        System.out.println("Please input animal's owner Name: \n");
        System.out.println("First Name: ");
        String animal_ofn = reader.next();

        System.out.println("Last Name: ");
        String animal_oln = reader.next();

        //Adding species.
        System.out.println("Please input animal species: ");
        String animal_s = reader.next();

        //Adding Date of Birth.
        System.out.println("Please input animal Date of Birth: ");
        String animal_dob = reader.next();

        //Adding Treatments
        List <String> animal_treatments = new ArrayList <String>();
        System.out.println("Please input treatments: ");

        int i = 0;
        while (i < 10) {
            String s = reader.next();
            if (s.equals("q") || s.equals("Q")) {
                break;
            }
            animal_treatments.add(s);
            i += 1;
        }
        System.out.println(animal_treatments);

        reader.close();
    }

    public void closeFile() {
        form.close();
    }

}