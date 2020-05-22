import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Integer> resultIndexes = new ArrayList<Integer>();

    public static void main(final String[] args) {
        List<Integer> testHashes = new ArrayList<Integer>();

        populateHash(testHashes);

        Integer compHand = new Integer(10);

        for(int i = 0; i < testHashes.size(); i++){
            if(isBanned(i)){
                continue;
            }
            Integer valueA = testHashes.get(i);

            if(valueA.equals(compHand)){
                resultIndexes.add(i);
            } else {
                Integer valueB = compHand - valueA;
                int index = testHashes.indexOf(valueB);

                if(!isBanned(index) && index > -1 && index != i){
                    resultIndexes.add(i);                   
                    resultIndexes.add(testHashes.indexOf(valueB));
                }
            }
        }
        for(int i : resultIndexes){
            System.out.println("Index: "+i+"; Value: "+testHashes.get(i));
        }
    }

    private static boolean isBanned(final Integer i){
        return resultIndexes.contains(i);
    }

    private static void populateHash(final List<Integer> hashes) {
        hashes.add(1);
        hashes.add(3);
        hashes.add(1);
        hashes.add(1);
        hashes.add(10);
        hashes.add(10);
        hashes.add(10);

        hashes.add(7); hashes.add(1); hashes.add(10); hashes.add(5);
        hashes.add(8); hashes.add(1); hashes.add(1); hashes.add(6);
        hashes.add(1); hashes.add(1); hashes.add(2);


    }
}