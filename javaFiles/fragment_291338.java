import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.lang.Math;
import java.util.Iterator;

class Test {
  public static void main(String[] args) {
    testArrayListImplementation();
    testLinkedListImplementation();
    testCaseFourMixed();
    testCaseFiveMixed();
  }

  static void testArrayListImplementation() {
    List<BigDecimal> bigDecList = new ArrayList<BigDecimal>();
    List<Integer> ndxList = new ArrayList<Integer>();

    System.out.println("ArrayList Implementation:");
    timeListImplementation(bigDecList, ndxList, false);
  }

  static void testLinkedListImplementation() {
    List<BigDecimal> bigDecList = new LinkedList<BigDecimal>();
    List<Integer> ndxList = new LinkedList<Integer>();

    System.out.println("LinkedList Implementation with Stream and Map:");
    timeListImplementation(bigDecList, ndxList, false);

    System.out.println("LinkedList Implementation with Iterator:");
    timeListImplementation(bigDecList, ndxList, true);
  }

  static void testCaseFourMixed() {
    //Test case 4
    List<BigDecimal> bigDecList = new LinkedList<BigDecimal>();
    List<Integer> ndxList = new ArrayList<Integer>();

    System.out.println("Mix test case #4:");
    timeListImplementation(bigDecList, ndxList, false);
  }

  static void testCaseFiveMixed() {
    //Test case 5
    List<BigDecimal> bigDecList = new ArrayList<BigDecimal>();
    List<Integer> ndxList = new LinkedList<Integer>();

    System.out.println("Mix test case #5:");
    timeListImplementation(bigDecList, ndxList, false);
  }

  static void timeListImplementation(List<BigDecimal> bigDecList, List<Integer> ndxList, boolean useIterator) {
    for (int i = 0; i < 10000; i++) {
      bigDecList.add(new BigDecimal(123.4));
      ndxList.add((int) (Math.random() * 1000));
    }

    long totalDuration = 0;

    for (int linkedTrial = 0; linkedTrial < 5; linkedTrial++) {
      long startTime = System.nanoTime();

      for (int numComputations = 0; numComputations < 100; numComputations++) {
        if (useIterator) {
          Iterator<Integer> ndxIter = ndxList.iterator();
          List<BigDecimal> specializedList = new LinkedList<BigDecimal>();
          while (ndxIter.hasNext()) {
            specializedList.add(bigDecList.get(ndxIter.next()));
          }
        } else {
          List<BigDecimal> specializedList = ndxList.stream().map(bigDecList::get).collect(Collectors.toList());
        }
      }

      long endTime = System.nanoTime();
      long duration = (endTime - startTime) / 1000000; //milliseconds

      System.out.println("Duration: " + duration + " milliseconds");
      totalDuration += duration;
    }
    System.out.println("Average duration: " + (totalDuration / 5) + " milliseconds");
  }
}