import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

class FloatEntryComparator implements Comparator<Map.Entry> {
  public int compare(Map.Entry e1, Map.Entry e2) {
    return ((Float)e2.getValue()).intValue() - ((Float)e1.getValue()).intValue();
  }
}

void setup() {
  Map<Float,Float> hm = new HashMap<Float,Float>();

  // Putting key-value pairs in the HashMap
  for (int i = 0; i < 100; i++) {
    float pos = random(-50, 50);
    float time = random(0, 50);
    hm.put(time, pos);
  }

  println("ALL ENTRIES, UNSORTED:");  
  for (Map.Entry me : hm.entrySet()) {
    print("key is " + me.getKey());
    println(" value is " + me.getValue());
  }

  List<Map.Entry> entries = new ArrayList<Map.Entry>(hm.entrySet());

  java.util.Collections.sort(entries, new FloatEntryComparator());

  hm = new LinkedHashMap<Float, Float>();
  for(Map.Entry e : entries)
    hm.put((Float)e.getKey(), (Float)e.getValue());

  println("5 LARGEST ENTRIES:");  
  int shownCount = 0;
  for (Map.Entry me : hm.entrySet()) {
    if(shownCount == 5)
      break;
    print("key is " + me.getKey());
    println(" value is " + me.getValue());
    ++shownCount;
  }
}