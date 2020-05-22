public class NameSearch{

    static ArrayList<String> names;
    int length;

    public static void main(String[] args)throws IOException{

        NameSearch sorter = new NameSearch();
        File f = new File("src/names.txt");
        Scanner scan = new Scanner(f);
        Scanner input = new Scanner(System.in);
        names = new ArrayList<>();

        int counter = 0;

        while(scan.hasNext()){
            names.add(scan.next());
        }

        sorter.sort(names);
        System.out.println(names.toString());
        scan.close();

        System.out.println("Enter a name you want to search: ");
        String s = input.nextLine();
        sorter.binarySearch(s, names);

    }

    public String toString(){
        return "Name: "+ names;
    }



    void sort(ArrayList<String> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        this.names = array;
        this.length = array.size();
        quickSort(0, length - 1);
    }

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names.get(lowerIndex + (higherIndex - lowerIndex) / 2);

        while (i <= j) {
            while (this.names.get(i).compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names.get(j).compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void exchangeNames(int i, int j) {
        Collections.swap(this.names, i, j);
    }

    void binarySearch(String s, ArrayList<String> ar){
        String stringToFind = s;
        int lowestIndex = 0;
        int highestIndex = ar.size()-1;
        int middleIndex = 0;

        while(lowestIndex<=highestIndex){
            middleIndex = (lowestIndex+highestIndex)/2;

            if(stringToFind.compareTo(ar.get(middleIndex)) > 0){
                lowestIndex = middleIndex+1;
            }else if(stringToFind.compareTo(ar.get(middleIndex)) < 0){
                highestIndex = middleIndex - 1;
            }else{
                break;
            }
        }

        if(lowestIndex > highestIndex){
            System.out.println("not found");
        }else{
            System.out.println("found at " + middleIndex);
        }
    }
}