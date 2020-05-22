private static Map<String,Object> max = new HashMap<String,Object>();
private static class IntMaxTrack {
     private final String key;
     private int value;
     public IntMaxTrack(String k, int v) {
         key = k;
         value = v;
         max.put(key, value);
     }
     public int get() { return value; }
     public void set(int v) {
         int m = ((Integer)max.get(key)).intValue();
         value = v;
         if (value > m) {
             max.put(key, value);
         }
     }
     public double norm() {
         int m = ((Integer)max.get(key)).intValue();
         return val / ((double)m);
     }
}