public class PriorityComparator  implements Comparator<String> {

Map<String, Double> base;
public PriorityComparator(Map<String, Double> base) {
    this.base = base;
}


public int compare(String a, String b) {
    if (base.get(a) <= base.get(b)) {
        return -1;
    } else {
        return 1;
    } 
  }
}