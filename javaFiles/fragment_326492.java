Map<Integer, String> testing1 = new TreeMap<>();
Map<Integer, String> testing2 = new TreeMap<>();

testing1.put(1, "one");
testing1.put(2, "two");
testing2.put(3, "three");
testing2.put(4, "four");

int lastKey1 = ((TreeMap<Integer, String>) testing1).lastKey();
int lastKey2 = ((TreeMap<Integer, String>) testing2).lastKey();
for (Map.Entry<Integer,String> something: testing1.entrySet()) {
      for (Map.Entry<Integer,String> something2: testing2.entrySet()) {
         if(something.getKey() == lastKey1  && something2.getKey() == lastKey2){
             // do your work
         }
      }
    }