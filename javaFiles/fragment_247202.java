public static void main(String[] args){
    ArrayList<String> allFileLines = readFileText("reels_template.txt");

    for(String line : allFileLines)
        System.out.println(line);
}