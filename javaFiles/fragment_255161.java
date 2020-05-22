public class Main
{

  public static void main(String[] args)
  {
    Vector <ArrayList<LinkedList<Pair>>> myData = new Vector<ArrayList<LinkedList<Pair>>>(); //vector

    for (int i = 0; i <= 2; i++) { //ArrayList
      myData.addElement(new ArrayList<LinkedList<Pair>>());
      for (int j = 0; j <= 1; j++) { //LinkedList
        myData.get(i).add(new LinkedList<Pair>());
        for (int k = 0; k <= 4; k++) { //Pair
             myData.get(i).get(j).add(new Pair<Integer>(1 ,2));
        }
      }
    }
  }
}

class Pair<T> {
    T first;
    T second;

  public Pair(T first, T second) {
       this.first = first;
       this.second = second;
  }
}