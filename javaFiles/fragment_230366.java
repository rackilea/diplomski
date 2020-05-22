import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Persons {
    public String name;
    public String lastName;
    public String Birthplace;
    public String dateBirth;
    Persons(String name, String lastName, String Birthplace, String dateBirth) {
        this.name = name;
        this.lastName = lastName;
        this.Birthplace = Birthplace;
        this.dateBirth = dateBirth;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPlace() {
        return Birthplace;
    }
    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd ',' MMM yyyy", Locale.ENGLISH);
        SimpleDateFormat parser = new SimpleDateFormat("ddMMyyyy");
        List<Persons> details = new ArrayList<Persons>();
        String text = "John.Davidson/05051988/Belgrade Michael.Barton/01011968/Krakov Ivan.Perkinson/23051986/Moscow";
        String[] personsSplit = text.split(" ");
        for (int i = 0; i < personsSplit.length; i++) {
            String[]  personList = personsSplit[i].split("/");
            String[] print = personList[0].split("\\.");
            Persons newPerson = new Persons(print[0], print[1],
                    personList[2],  personList[1]);
            details .add(newPerson);
        }
        for (int i = 0; i <details .size(); i++) {
            String outputString = "Person " + i + ": "
                    + details .get(i).getName() + " "
                    + details .get(i).getLastName() + ", "
                    +formatter.format(parser.parse(details .get(i).getDateBirth())) + ", "
                    + details .get(i).getPlace() + ";";
            System.out.println(outputString);
        }
    }
}