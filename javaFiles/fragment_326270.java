Scanner sc = new Scanner(new File("/home/alain/Bureau/ttt.txt"));

//loop over real EOL
while(sc.hasNextLine()){

     //Replace the `\n` in the line with real EOL.
     System.out.println(sc.nextLine().replace("\\n", System.getProperty("line.separator")));
}