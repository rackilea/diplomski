String[] pictureFile   = {"a.jpg","b.jpg","c.jpg","d.jpg","e.jpg","f.jpg","g.jpg"};
  List <String>  pic1= Arrays.asList(pictureFile);
      ...
  ListGenerator pic2= new ListGenerator(pic1);

  public class ListGenerator {

     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

     public ListGenerator(List<String> pic1) {
        int size = pic1.size();

        // create a list of all possible combinations
        for(int i = 0 ; i < size ; i++) {
           for(int j = (i+1) ; j < size ; j++) {
              ArrayList<Integer> temp = new ArrayList<Integer>();
              temp.add(i);
              temp.add(j);

              Collections.shuffle(temp);
              result.add(temp);
           }
        }
        Collections.shuffle(result);
     }

     //This method return the shuffled list
     public ArrayList<ArrayList<Integer>> getList()  {
        return result;
     }
  }