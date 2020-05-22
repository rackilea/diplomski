public static void main(String[] args) throws FileNotFoundException {
    HashSet<String> words = new HashSet<String>();
    File dir = new File("filestxt");
    for (File f : dir.listFiles()) {
        Scanner in = new Scanner(f);
        while(in.hasNextLine()) {
            words.add(in.nextLine());
        }//end while
    }//end for

    //Create 5 different shufflings of the words
    for (int i = 0; i < 5; i++) {
        List<String> shuffle = new ArrayList<String>();
        for (String s : words) {
            shuffle.add(s);
        }//end for
        Collections.shuffle(shuffle);
        System.out.println(shuffle);
     }
}