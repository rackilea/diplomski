import java.util.*;

public class Test {
  public static void main(String[] args) {
    String[] customers = {
      "Mr PoopyButtHole", "Stealy", "Bird Person"
    };

    CarBrand audi = new CarBrand("Audi");
    CarBrand bmw = new CarBrand("BMW");
    CarBrand mazda = new CarBrand("Mazda");
    CarBrand vw = new CarBrand("VW");
    CarBrand ferrari = new CarBrand("Ferrari");

    // First Map: Customers paired with car brands they've rented
    SortedMap<String, List<CarBrand>> customerRentals =
      new TreeMap<String, List<CarBrand>>();
    // --- Fill the first map with info ---
    // For customer Mr PoopyButtHole
    List<CarBrand> mrPBHRentals = new ArrayList<>();
    Collections.addAll(mrPBHRentals, audi, bmw, mazda);
    customerRentals.put(customers[0], mrPBHRentals);
    // For customer Stealy
    List<CarBrand> stealyRentals = new ArrayList<>();
    Collections.addAll(stealyRentals, bmw, mazda, vw);
    customerRentals.put(customers[1], stealyRentals);
    // For customer Bird Person
    List<CarBrand> birdPersonRentals = new ArrayList<>();
    Collections.addAll(birdPersonRentals, audi, bmw, mazda, ferrari);
    customerRentals.put(customers[2], birdPersonRentals);

    // First Map contains 10 occurences of car brands across all the individual
    // arraylists paired to a respective customer

    // Second Map: Car brands paired with the amount of times they've been
    // rented
    // You don't actually need the second map to be a TreeMap as you want to
    // rearrange the results into your desired format at the end anyway
    Map<CarBrand, Integer> carBrandRentalCounts = new HashMap<>();
    // Place each CarBrand into carBrandRentalCounts and initialize the counts
    // to zero
    carBrandRentalCounts.put(audi, 0);
    carBrandRentalCounts.put(bmw, 0);
    carBrandRentalCounts.put(mazda, 0);
    carBrandRentalCounts.put(vw, 0);
    carBrandRentalCounts.put(ferrari, 0);

    // Get all the values (each ArrayList of carbrands paired to a customer) in
    // the first map
    Collection<List<CarBrand>> values = customerRentals.values();

    // Iterate through 'values' (each ArrayList of car brands rented)
    int total = 0;
    for(List<CarBrand> aCustomersRentals : values)
      for(CarBrand brand : aCustomersRentals) {
        // Get the current count for 'brand' in the second map
        Integer brandCurrentCount = carBrandRentalCounts.get(brand);
        // Increment the count for 'brand' in the second map
        Integer newBrandCount = brandCurrentCount+1;
        carBrandRentalCounts.put(brand, newBrandCount);

        total++;
      }

    // Init. a List with the entries
    Set<Map.Entry<CarBrand,Integer>> entries = carBrandRentalCounts.entrySet();
    List<Map.Entry<CarBrand,Integer>> listOfEntries =
      new ArrayList<Map.Entry<CarBrand,Integer>>(entries);
    // Sort the entries with the following priority:
    // 1st Priority: Highest count
    // 2nd Priority: Alphabetical order
    // NOTE: CustomSortingComparator implements this priority
    Collections.sort(listOfEntries, new CustomSortingComparator());

    // Print the results
    System.out.println("Count of rentals for each car brand:");
    for(Map.Entry<CarBrand, Integer> entry : listOfEntries)
      System.out.println("  " + entry.getKey() + " --> " + entry.getValue());
    System.out.println("Total:" + total);

    // Verify that our custom sorted entries are indeed being sorted correctly
    // Change the counts to be all the same
    for(Map.Entry<CarBrand, Integer> entry : entries)
      entry.setValue(10);
    // Resort the entries
    Collections.sort(listOfEntries, new CustomSortingComparator());
    // Print with the test entries
    System.out.println();
    System.out.println("With test entries where all counts are the same:");
    for(Map.Entry<CarBrand, Integer> entry : listOfEntries)
      System.out.println("  " + entry.getKey() + " --> " + entry.getValue());
    System.out.println("Total:" + total);
    // Change the counts so that the ordering is the alphabetically highest
    // brands followed by the lowest
    for(int i = listOfEntries.size()-1; i >= 0; i--)
      listOfEntries.get(i).setValue(i);
    // Resort the entries
    Collections.sort(listOfEntries, new CustomSortingComparator());
    // Print with the test entries
    System.out.println();
    System.out.println("with test entries where the \"bigger\" car brands " +
      "alphabetically have higher counts:");
    for(Map.Entry<CarBrand, Integer> entry : listOfEntries)
      System.out.println("  " + entry.getKey() + " --> " + entry.getValue());
    System.out.println("Total:" + total);
  }
}

class CustomSortingComparator
implements Comparator<Map.Entry<CarBrand,Integer>> {
  public int compare(Map.Entry<CarBrand, Integer> entry1,
                     Map.Entry<CarBrand, Integer> entry2) {
    CarBrand brand1 = entry1.getKey();
    CarBrand brand2 = entry2.getKey();
    int brandResult = brand1.compareTo(brand2);
    Integer count1 = entry1.getValue();
    Integer count2 = entry2.getValue();
    int countResult = count1.compareTo(count2);

    return
      countResult > 0 ?
        -1 : countResult < 0 ?
          1 : brandResult < 0 ?  // <-- equal counts here
            -1 : brandResult > 1 ?
              1 : 0;
  }
}

// DONT WORRY ABOUT THIS CLASS, JUST MAKES IT EASIER TO IDENTIFY WHAT'S GOING
// ON IN THE FIRST MAP
class CarBrand implements Comparable<CarBrand> {
  public final String brand;

  public CarBrand(String brand) { this.brand = brand; }

  @Override
  public int compareTo(CarBrand carBrand) {
    return brand.compareTo(carBrand.brand);
  }

  @Override
  public boolean equals(Object o) {
    // IF o references this CarBrand instance
    if(o == this) return true;
    // ELSE IF o is of type CarBrand, perform equality check on field 'brand'
    else if(o instanceof CarBrand) {
      CarBrand obj = (CarBrand)o;
      // IF the brands are equal, o is equal to this CarBrand
      if(brand.equals(obj.brand)) return true;
    }

    return false;
  }

  @Override
  public String toString() { return brand; }

  @Override
  public int hashCode() { return brand.hashCode(); }
}