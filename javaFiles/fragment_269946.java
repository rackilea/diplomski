public class Main {

    public Main () {
        Scanner scan;
        scan = new Scanner(System.in);
        String input = scan.nextLine(); 
        if(check(split(input), split("apple"))) {
            System.out.println("letters are the same");
        }
        else {
            System.out.println("contains different letters");
        }
    }

    public boolean check(ArrayList<String> listA, ArrayList<String> listB) {
        listA.removeAll(listB); //listA will contain any letters not common to listB
        if (listA.size() == 0) 
            return true;
        return false;
    }

    public ArrayList<String> split(String word) {
        String[] splitMe = word.split("(?!^)");
        ArrayList<String> splitList = new ArrayList<String>();
        for (int i = 0; i < splitMe.length; i++) {
            splitList.add(splitMe[i]);  
        }
        System.out.println(splitList);
        return splitList;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}