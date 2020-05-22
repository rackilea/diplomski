public static int function(int key) {
    System.out.print("printing: " + key + " " + Thread.currentThread ().getName () + " ");
    return key;
}

public static void main (java.lang.String[] args)
{
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i = 1 ; i <= 2 ; i ++) {
        map.put(i,i);     
    }

    map.entrySet().parallelStream()
                  .map(batch -> function(batch.getKey()))
                  .collect(Collectors.toList());
}