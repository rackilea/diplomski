public class ArrayObject {

private String[] names = {"Player 1", "Player 2"};

/**
 * @param args
 */
public static void main(String[] args) {
    ArrayList<String> myArrayList = new ArrayList<String>();
    new ArrayObject().setName(myArrayList);
}

public void setName(ArrayList<String> objectName) {
    for(int x = 0; x < names.length; x++) {
        objectName.add(names[x]);
    }

    // Testoutput
    for(int x = 0; x < objectName.size() ; x++) {
        System.out.println(objectName.get(x));
    }
}