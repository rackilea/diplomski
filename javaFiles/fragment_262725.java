import java.text.*;
import java.util.*;

public class Example
{
    public static void main(String[] args) {
        // create simple test harness
        Set<PeopleByDays> peepsByDay = new HashSet<PeopleByDays>();
        peepsByDay.add(new PeopleByDays(new Date(2015 - 1900, Calendar.JANUARY, 1),
            Person.BOB, Person.FRANK, Person.JIM, Person.JUDY, Person.SALLY));
        peepsByDay.add(new PeopleByDays(new Date(2015 - 1900, Calendar.JANUARY, 2),
            Person.BOB, Person.FRANK, Person.JIM, Person.JUDY, Person.TOMMY));
        peepsByDay.add(new PeopleByDays(new Date(2015 - 1900, Calendar.JANUARY, 3),
            Person.BOB, Person.FRANK, Person.JIM, Person.SALLY, Person.TOMMY));
        peepsByDay.add(new PeopleByDays(new Date(2015 - 1900, Calendar.JANUARY, 4),
            Person.BOB, Person.FRANK, Person.JUDY, Person.SALLY, Person.TOMMY));
        peepsByDay.add(new PeopleByDays(new Date(2015 - 1900, Calendar.JANUARY, 5),
            Person.BOB, Person.JIM, Person.JUDY, Person.SALLY, Person.TOMMY));

        // make powerSet, then intersect, then sort
        Set<Set<PeopleByDays>> powerPeeps = powerSet(peepsByDay);
        List<PeopleByDays> powerPeepsIntersected = intersect(powerPeeps);
        sort(powerPeepsIntersected);

        // print out results
        for (PeopleByDays peeps: powerPeepsIntersected) {
            String daysFormatted = format(peeps.getDays());
            System.out.print(daysFormatted);
            System.out.println(peeps);
        }
    }

    // all other Example members as defined in this answer
}