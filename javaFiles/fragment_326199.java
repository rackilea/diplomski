import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
...
HashSet<? extends Comparable> myHashSet = ...;
...
List<? extends Comparable> sortedList = Arrays.asList(myHashSet.toArray(new Comparable[0]));
Collections.sort(sortedList);