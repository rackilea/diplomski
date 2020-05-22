public static void main(String[] args) 
{
    ArrayList<Integer> tab = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    System.out.println("4) Average : " + average(tab));
}


public static int addition(ArrayList<Integer> list){
      int sum = 0;
      for(int i=0;i<list.size();i++){
         sum+= list.get(i);
      }
      return sum;
}

public static double average(ArrayList<Integer> list){
    return (double) addition(list) / list.size();
}