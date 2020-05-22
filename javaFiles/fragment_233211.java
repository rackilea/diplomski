import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

class Animal implements Comparable<Animal>
{
    private final int weight;

    Animal(int weight)
    {
        this.weight = weight;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public int compareTo(Animal that)
    {
        return Integer.compare(this.weight, that.weight);
    }
}

public class CollectionBinarySearch
{
    public static void main(String[] args)
    {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal(10));
        animals.add(new Animal(40));
        animals.add(new Animal(20));
        animals.add(new Animal(90));
        animals.add(new Animal(290));
        animals.add(new Animal(130));

        Collections.sort(animals);

        System.out.println(searchWithInstance(animals, 90));
        System.out.println(searchWithInstance(animals, 50));

        System.out.println(searchWithArray(animals, 90));
        System.out.println(searchWithArray(animals, 50));

        System.out.println(searchWithFunction(animals, Animal::getWeight, 90));
        System.out.println(searchWithFunction(animals, Animal::getWeight, 50));

    }

    public static int searchWithInstance(
        final List<? extends Animal> list, final int weight) {
        return Collections.binarySearch(list, new Animal(weight));
    }

    public static int searchWithArray(
        final List<? extends Animal> list, final int weight) {
        int[] array = list.stream().mapToInt(Animal::getWeight).toArray();
        return Arrays.binarySearch(array, weight);
    }        

    // Adapted from Collections#binarySearch
    private static <T, K extends Comparable<? super K>> int searchWithFunction(
        List<? extends T> list, Function<? super T, K> keyExtractor, K key) {
        int low = 0;
        int high = list.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = keyExtractor.apply(midVal).compareTo(key);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

}