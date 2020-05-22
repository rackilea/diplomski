import java.util.ArrayList;
import java.util.Arrays;

public class TestQuestion {

    public static void main(String[] args) {
        // inital objects to be stored
        ArrayList<String> arr1 = new ArrayList<String>(
                Arrays.asList((new String[] { "ins1: test string1",
                        "ins1: test string2", "ins1: test string3" })));
        PlaceHolderObject<String> pho1 = new PlaceHolderObject<String>();
        pho1.setArrayList(arr1);

        ArrayList<String> arr2 = new ArrayList<String>(
                Arrays.asList((new String[] { "ins2: test string1",
                        "ins2: test string2", "ins2: test string3" })));
        PlaceHolderObject<String> pho2 = new PlaceHolderObject<String>();
        pho2.setArrayList(arr2);

        ArrayList<String> arr3 = new ArrayList<String>(
                Arrays.asList((new String[] { "ins3: test string1",
                        "ins3: test string2", "ins3: test string3" })));
        PlaceHolderObject<String> pho3 = new PlaceHolderObject<String>();
        pho3.setArrayList(arr3);

        // gather up all instance in one
        ArrayList<PlaceHolderObject<String>> listOfInstances = new ArrayList<PlaceHolderObject<String>>();

        // assignments
        listOfInstances.add(pho1);
        listOfInstances.add(pho2);
        listOfInstances.add(pho3);

        // print contents of listOfInstances objects
        System.out.println("Contents of the 'listOfInstances' list");
        System.out.println("**************************************");

        for (int i = 0; i < listOfInstances.size(); i++)
            System.out.println(listOfInstances.get(i).getArrayList());

        System.out.println();

        // print references of the contents of listOfInstances objects
        System.out.println("References of the 'listOfInstances' list");
        System.out.println("****************************************");

        for (int i = 0; i < listOfInstances.size(); i++) {
            System.out.println(i+1 + "th Object: " + listOfInstances.get(i) );
            System.out.println("   ArrayList hashcode: " + listOfInstances.get(i).getArrayList().hashCode()  );
        }

        // Remove second item of the second object
        listOfInstances.get(1).getArrayList().remove(1);
        System.out.println();
        System.out.println();

        // print contents of listOfInstances objects
        System.out.println("Contents of the 'listOfInstances' updated list");
        System.out.println("**********************************************");

        for (int i = 0; i < listOfInstances.size(); i++)
            System.out.println(listOfInstances.get(i).getArrayList());

        System.out.println();

        // print references of the contents of updated listOfInstances objects
        System.out.println("References of the 'listOfInstances' updated list");
        System.out.println("************************************************");

        for (int i = 0; i < listOfInstances.size(); i++) {
            System.out.println(i+1 + "th Object: " + listOfInstances.get(i) );
            System.out.println("   ArrayList hashcode: " + listOfInstances.get(i).getArrayList().hashCode()  );
        }

    }

    // A POJO class that only stores an arrayList
    public static class PlaceHolderObject<T> {
        private ArrayList<T> arrayList;

        // no-arg default constructor
        public PlaceHolderObject() {
        }

        // parametric constructor
        public PlaceHolderObject(ArrayList<T> arrayList) {
            this.arrayList = arrayList;
        }

        public ArrayList<T> getArrayList() {
            return arrayList;
        }

        public void setArrayList(ArrayList<T> arrayList) {
            this.arrayList = arrayList;
        }

    }

}