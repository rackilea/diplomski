public static void main(String[] args) {
    int k = 3;
    List<Integer> marks = new ArrayList<Integer>();
    marks.add(20);
    marks.add(20);
    marks.add(40);
    marks.add(60);
    marks.add(20);
    marks.add(10);
    marks.add(0);
    marks.add(100);
    System.out.println(numofPrizes(k, marks));
}
public static int numofPrizes(int k, List<Integer> list) {
              list.sort(Collections.reverseOrder());
      int number = 0,counter = 1;
      int[] mark = new int[list.size()],rank = new int[list.size()];
      Map<Integer,Integer> map  = new HashMap<Integer,Integer>();   
      for (int i = 0; i < list.size(); i++) {
              map.put(list.get(i), (map.get(list.get(i)) != null) ? map.get(list.get(i)) : counter);
              mark[i] = list.get(i);
              rank[i] = (int) map.get(list.get(i));
              counter++;
              if(mark[i] > 0 && k >= rank[i]){
                      number++;
              }
      }          
      return number;   
}