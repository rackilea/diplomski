public static void main(String args[]) {
    String filename;
    if(Board.state == Board.STATE.LEVEL1) {
        filename = "D://OOP Photos//Map1.txt";
    }
    else if (Board.state == Board.STATE.LEVEL2) {
        filename = "D://OOP Photos//Map2.txt";
    }
    else if (Board.state == Board.STATE.LEVEL3) {
        filename = "D://OOP Photos//Map3.txt";
    }
    readFile(filename);
}

public void readFile(String filename) { 
    try {
        Scanner scan = new Scanner(new File(filename));

        int i = 0;
        while(scan.hasNext()) {
            Map[i] = scan.next();
            i++;
        }
    }
    catch(FileNotFoundException e) {
        System.out.println("Error loading MAP !!! ");
    }
}