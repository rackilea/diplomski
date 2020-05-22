import java.util.*;
import java.util.stream.Collectors;
class Main{
  public static void main(String[] args) {
    int[] A = {1,2,3,4,5};

    // Convert your int-array to an Integer-ArrayList:
    List<Integer> inputList = Arrays.stream(A).boxed().collect(Collectors.toList());

    // Get all possible partitions of this List:
    List<List<List<Integer>>> partitions = partition(inputList);
    System.out.println("All partitions: ");
    prettyPrintPartitions(partitions);

    // Remove all items which aren't in the original order:
    filterPartitionsByOriginalOrder(partitions, A);
    System.out.println("\nPartitions that are in the original order: ");
    prettyPrintPartitions(partitions);

    // Filter them based on amount of chunks `k`:
    for(int k=2; k<A.length; k++){
      System.out.println("\nPartitions of size "+k+" (and also in the original order): ");
      List<List<List<Integer>>> filteredPartitions = filterPartitionsByAmountOfChunks(partitions, k);
      prettyPrintPartitions(filteredPartitions);
    }
  }

  private static void prettyPrintPartitions(List<List<List<Integer>>> partitions){
    for(List<List<Integer>> partition : partitions){
      System.out.println(partition);
    }
  }

  /* Method to get all partitions (all possible ways to divide the list in a variable amount of chunks) of a List of Integers */
  private static List<List<List<Integer>>> partition(List<Integer> inputList) {
    List<List<List<Integer>>> result = new ArrayList<>();
    if(inputList.isEmpty()){
      List<List<Integer>> empty = new ArrayList<>();
      result.add(empty);
      return result;
    }
    // Note that this algorithm only works if inputList.size() < 31
    // since you overflow int space beyond that. This is true even
    // if you use Math.pow and cast back to int.
    int limit = 1 << (inputList.size() - 1);
    // Note the separate variable to avoid resetting
    // the loop variable on each iteration.
    for(int j=0; j<limit; j++){
      List<List<Integer>> parts = new ArrayList<>();
      List<Integer> part1 = new ArrayList<>();
      List<Integer> part2 = new ArrayList<>();
      parts.add(part1);
      parts.add(part2);
      int i = j;
      for(Integer item : inputList){
        parts.get(i%2).add(item);
        i >>= 1;
      }
      for(List<List<Integer>> b : partition(part2)){
        List<List<Integer>> holder = new ArrayList<>();
        holder.add(part1);
        // Add them at the start instead of end so the items hold the original order
        holder.addAll(0, b);
        result.add(holder);
      }
    }
    return result;
  }

  /* Method to filter a List of List of List of Integers (partitions) based on a given amount of chunks `k` */
  private static List<List<List<Integer>>> filterPartitionsByAmountOfChunks(List<List<List<Integer>>> partitions, int k){
    List<List<List<Integer>>> filteredPartitions = partitions.stream()
                                                             .filter(partition -> partition.size() == k)
                                                             .collect(Collectors.toList());
    return filteredPartitions;
  }


  /* Method to remove any partition that (flattened) isn't in the same order as the original given int-array */
  private static void filterPartitionsByOriginalOrder(List<List<List<Integer>>> partitions, int[] A){
    partitions.removeIf(partition -> {
      int index = 0;
      for(List<Integer> part : partition){
        for(int value : part){
          // The value is not at the same index in the original array,
          // so remove the partition
          if(value != A[index]){
            return true;
          }
          index++;
        }
      }
      return false;
    });
  }
}