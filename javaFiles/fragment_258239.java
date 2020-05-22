static Scanner reader = new Scanner(System.in);

public static void main(String[] args) {    
    String pat = reader.nextLine();

    ArrayList<String> names = new ArrayList<String>();
    names.add("anna");
    names.add("bob");
    names.add("matthew");
    names.add("charles");
    names.add("effron");
    System.out.print(newArray(names, pat));
}

public static ArrayList<String> newArray(ArrayList<String> arr, String str) {
    ArrayList<String> alphabetized = new ArrayList<String>(arr.size());
    arr.add(str);
    java.util.Collections.sort(arr);

    return arr;
    //for (int x=0; x<arr.size();x++){
    //    alphabetized.add(arr.get(x));
    //}
    //return alphabetized;
}