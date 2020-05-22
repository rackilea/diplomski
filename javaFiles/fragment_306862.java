import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class JVMDataService extends ScheduledService<List<Person>> {

    private final Random generator = new Random();

    @Override
    protected Task<List<Person>> createTask() {
        return new Task<List<Person>>() {

            @Override
            protected List<Person> call() throws Exception {
                int n = generator.nextInt(50);
                List<Person> persons = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    System.out.println("i = " + i);
                    persons.add(new Person("Max", "Mustermann", "max" + i + ".mustermann@example.com"));
                }
                return persons;
            }
        };
    };

}