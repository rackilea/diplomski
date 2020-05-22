import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class MinMaxTest {

    public static void main(String[] args) {

        Random rand = new Random();


        //Assuming an array list of people...
        Collection<Person> people = new ArrayList<>();


        for (int i = 0; i < 50; i++){
            Person p = new Person();
            p.setMyvalue(rand.nextFloat());
            p.setDate(new Date(rand.nextLong()));
            people.add(p);
        }

        //This is how you get the max and min value people
        Person maxValuePerson = people.parallelStream()
                .max(Comparator.comparing(p -> ((Person) p).getMyValue()))
                .get();
        Person minValuePerson = people.parallelStream()
                .min(Comparator.comparing(p -> ((Person) p).getMyValue()))
                .get();

        //to group the people by month do the following:
        HashMap<Integer,ArrayList<Person>> monthMap = new HashMap<>();

        Calendar cal = Calendar.getInstance();

        for (Person p : people){
            cal.setTime(p.getDate());
            int month = cal.get(Calendar.MONTH);
            ArrayList<Person> monthList = monthMap.get(month);
            if(monthList == null)
                monthList = new ArrayList<>();
            monthList.add(p);
            monthMap.putIfAbsent(month, monthList);
        }

        for(Integer i : monthMap.keySet()){
            System.out.println("Month: "+ i);
            for(Person p : monthMap.get(i)){
                System.out.println(p);
            }
        }

    }

    static class Person implements Serializable {
        private float myvalue;
        private Date date;

        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public float getMyValue() {
            return myvalue;
        }
        public void setMyvalue(float myvalue) {
            this.myvalue = myvalue;
        }
    }

}