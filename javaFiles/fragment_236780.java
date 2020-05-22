File file = new File("data.txt");
private static final DELIMITER = "YOUR DELIMITER";
double[] doubleArray; 

try {

    Scanner scanner = new Scanner(file);
    int i=0;

    while (scanner.hasNextLine()) {
            String[] temp = scanner.nextLine().split(DELIMITER);
            for(int j=0; i<temp.length;++j){
                doubleArray[i] = Double.parseDouble(temp[j]);
                i++;
            }       
    }
    scanner.close();
} catch (FileNotFoundException e)
        e.printStackTrace();
}