import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public static Employee[] searchWithId(Employee[] list, String search) {
   System.out.println("Searching for the id number: " + search);
   return Arrays.asList(list)
            .stream()
            .filter(e -> e.idNumber.equalsIgnoreCase(search))
            .collect(Collectors.toList())
            .toArray(new Employee[list.length]);
}