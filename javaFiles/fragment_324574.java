import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestFilter {
    public Map<Integer, ArrayList<String>> dataMap;
    List<String> firstnames, lastnames, salarys, locations; // List is dynamic, you can add to it and delete at run time 

    public TestFilter(){
         firstnames = new ArrayList<String>(Arrays.asList( new String[]{"john", "david", "mathew", "john", "jerry", "Uffe", "Sekar", "Suresh", "Ramesh", "Raja"}));
         lastnames = new ArrayList<String>(Arrays.asList( new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"}));
         salarys = new ArrayList<String>(Arrays.asList( new String[]{"10000", "20000", "15000", "5323", "2000", "5346", "1000", "4889", "7854", "2438"}));
         locations = new ArrayList<String>(Arrays.asList( new String[]{"India", "Iceland", "Mexico", "Slovenia", "Poland", "Australia", "1000", "USA", "England", "Canada"}));
         populateDatabase();


    }

    public static void main(String argv[]) {
        TestFilter tf = new TestFilter(); // just example to test
        Scanner in = new Scanner(System.in);
        System.out.println("Insert First Name");
        String firstName = in.nextLine();
        System.out.println("Insert Last Name");
        String lastName = in.nextLine();
        System.out.println("Insert Salary");
        String salary = in.nextLine();
        System.out.println("Insert Location");
        String location = in.nextLine();
        System.out.println("Filter Result: " + tf.filter(firstName, lastName, salary, location));

        tf.addRecord("Yahya", "Almardeny", "3000", "Ireland"); //add new record
        System.out.println("After Adding: " + tf.dataMap); // test it

        tf.deleteRecord(new String[]{"Yahya", "Almardeny"}); // delete old record
        System.out.println("After Deleting: " + tf.dataMap); // test it

    }


    //this method will return the record (as ArrayList) if there is a match or null if there is not.
    public  ArrayList<String> filter(String firstName, String lastName, String salary,String location) {
        //attempt to filter
        for(Integer id : dataMap.keySet()){ //cycle through the database to find a match according to the conditions
            if (dataMap.get(id).contains(firstName) && dataMap.get(id).contains(lastName) ||
                    dataMap.get(id).contains(salary) && dataMap.get(id).contains(location)){
                return new ArrayList<String>(Arrays.asList(new String[]{id.toString(), dataMap.get(id).get(0), 
                        dataMap.get(id).get(1), dataMap.get(id).get(2), dataMap.get(id).get(3)}));
            }
        }
        return null;   
    }

    public void populateDatabase(){
     dataMap = new HashMap<Integer, ArrayList<String>>(); // create HashMap as a database give every new record auto increment integer as an Id
         for(int i=0; i<firstnames.size(); i++){
             dataMap.put(i, new ArrayList<String>(Arrays.asList(new String[]
                     {firstnames.get(i), lastnames.get(i), salarys.get(i), locations.get(i)}))); 
         } 
    }

    public void addRecord(String firstName, String lastName, String salary,String location){
        firstnames.add(firstName);
        lastnames.add(lastName);
        salarys.add(salary);
        locations.add(location);
        populateDatabase();
    }

    public void deleteRecord(Object obj){
        int position = -1;
        // delete by a combination of first and last names or salary and location
        if(obj instanceof String[]){ // first index is first name, second is last name OR first index is the salary and the second is the location
            for(Integer id : dataMap.keySet()){ //cycle through the database to find a match according to the conditions
                if (dataMap.get(id).contains(((String[]) obj)[0]) && dataMap.get(id).contains(((String[]) obj)[1]) ||
                        dataMap.get(id).contains(((String[]) obj)[0]) && dataMap.get(id).contains(((String[]) obj)[1])){

                    position = id;
                }
            }
        }
        if(position>-1){
            firstnames.remove(position);
            lastnames.remove(position);
            salarys.remove(position);
            locations.remove(position);
            populateDatabase();
        }

    }

}