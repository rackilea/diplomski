ArrayList<String> list = new ArrayList<String>();

Scanner inFile = null;
try {
inFile = new Scanner(new File("textfile.txt"));
} catch (FileNotFoundException e) {

e.printStackTrace();
}

while(inFile.hasNextLine()){
    list.add(inFile.nextLine());
}