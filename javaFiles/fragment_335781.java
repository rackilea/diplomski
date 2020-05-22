import java.util.Arrays;

public static Employee[] searchWithId(Employee[] list, String search) {
   System.out.println("Searching for the id number: " + search);            
   Employee[] filteredEmployees = new Employee[list.length];
   int index = 0;
   for (int i = 0; i < list.length; i++) {
      if (list[i].getIdNumber().equalsIgnoreCase(search)) {
         filteredEmployees[index++] = list[i];
      }
   }
   // It'll remove the null values:
   return Arrays.copyOfRange(filteredEmployees, 0, index);
}