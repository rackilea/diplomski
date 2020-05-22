public static Scanner scan;
public static void main(String[] args) {
    ArrayList<String> shd = new ArrayList<>();
    scan = new Scanner(System.in);
    String line = scan.nextLine();
    int lines = Integer.parseInt(line);
    //Loop scanner for each line
    for (int i=0;i<lines;i++){
        String currentLine = scan.nextLine().trim().replaceAll("-", "");
        String [] words = currentLine.split(" ");
        for (String word:words){
            shd.add(word);
        }
    }
    System.out.println(shd);
}