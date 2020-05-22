import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

class Main {
  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    String[] strDates = new String[] {"12.06.2019", "31.05.2019", "10.05.2010", "09.02.2012"};
    LocalDate[] dates = Stream.of(strDates).map(date -> LocalDate.parse(date, formatter))
                                           .toArray(LocalDate[]::new);

    System.out.println(String.format("Unsorted dates: %s", Arrays.toString(dates)));
    Arrays.sort(dates);
    System.out.println(String.format("Sorted dates: %s", Arrays.toString(dates)));

    System.out.println("Formatted Dates:");
    for (LocalDate d : dates) {
      System.out.println(formatter.format(d));
    }
  }
}