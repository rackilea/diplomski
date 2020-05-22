public class ListGenerator {

     ArrayList<String> result = new ArrayList<String>();

     public ListGenerator(char...  letters) {
        int size = letters.length;

        // create a list of all possible combinations
        for(int i = 0 ; i < size ; i++) {
           for(int j = (i+1) ; j < size ; j++) {
              ArrayList<Character> temp = new ArrayList<Character>();
              temp.add(letters[i]);
              temp.add(letters[j]);

              Collections.shuffle(temp);
              result.add("" + temp[0] + temp[1]);
           }
        }
        Collections.shuffle(result);
     }

     //This method return the shuffled list
     public ArrayList<ArrayList<Integer>> getPairs()  {
        return result;
     }
  }