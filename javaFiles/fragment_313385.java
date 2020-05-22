public class NotRepeatingRandom {
    int size;
    int index;
    List<Integer> vals;
    Random gen = new Random();

    public NotRepeatingRandom(int rangeMax) {
      size = rangeMax;
      index = rangeMax; // to force initial shuffle
      vals = new ArrayList<Integer>(size);
      fillBaseList();
    }

    private void fillBaseList() {
      for (int a=0; a<size; a++) {
        vals.add(a);
      }
    }

    public int nextInt() {
      if (index == vals.size()) {
          Collections.shuffle(vals);
          index = 0;
      }
      int val = vals.get(index);
      index++;      
      return val;
    }

    public static void main(String[] args) {
        NotRepeatingRandom gen = new NotRepeatingRandom(10);
        for (int a=0; a<30; a++) {
            System.out.println(gen.nextInt());
        }
    }
}