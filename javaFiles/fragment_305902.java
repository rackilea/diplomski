public class Main {     
    public int count = 0;
    public static void main(String[] args) throws Exception {   //Read user input into the array
        HashSet<Main> set = new HashSet<>();
        Main main = new Main();
        main.count = 3;

        set.add(main);
        main.count = 2; // changes what hashCode() returns 

        System.out.println(set.contains(main)); // prints false
    }

    public int hashCode() {
        return count;
    }
}