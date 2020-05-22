public class BinarySearch
{
  public static <T extends Comparable<T>> boolean Run(T[] list, T target)
  {
    int listLen = list.length;
    int min = 0;
    int max = list.length - 1;

    while (true) {
        int guess = (min + max / 2);
        if (target.equals(list[guess])) return true;

        if (list[guess].compareTo(target) < 0) { 
            // list[guess] is less than target
        } else {
            // list[guess] is larget than target
        }
    }
}