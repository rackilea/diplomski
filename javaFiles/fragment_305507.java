public static void main(String args[]) throws FileNotFoundException, IOException {

    ArrayList<String> list = new ArrayList<String>();

    Scanner inFile = null;
    try {
        inFile = new Scanner(new File("C:\\file.txt"));
    } catch (FileNotFoundException e) {

        e.printStackTrace();
    }

    while (inFile.hasNextLine()) {
        list.add(inFile.nextLine());
    }

    int line = 0;
    String[] parts = list.get(line).split(" ");
    String username = parts[0];
    String pass = parts[3]; 
    System.out.println("Line" + (line + 1) + ": " + "User is " + username +" and password is " + pass);
}