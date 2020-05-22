import java.util.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        // I made constructor for departureCountry only to keep it simple
        List<Flight> flights = Arrays.asList(
          new Flight("USA"),
          new Flight("UK"),
          new Flight("CAN"),
          new Flight("USA"),
          new Flight("UK")
        );

        Map<String, Long> flightsPerCountry =
          flights.stream()
                 .collect(groupingBy(Flight::getDepartureCountry, counting()));


        System.out.println(flightsPerCountry);
        // {CAN=1, USA=2, UK=2}
    }
}