public class MyClass {
    private ArrayList<String> namen = new ArrayList<>();

    public void addName(){
        System.out.print("Enter a name: ");
        Scanner in = new Scanner(System.in);
        namen.add(in.next());

        for(String naam: namen){
            System.out.println(naam);
        }
    }
}