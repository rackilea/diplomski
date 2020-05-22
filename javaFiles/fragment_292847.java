while(input_file.hasNextLine())  {
    String line = input_file.nextLine();
    System.out.printf("%s\n", line);
    int counta = 0; // Move this here if you want to count every a in each line
    for(int i = 0; i<line.length(); i++) {
        char aA = line.charAt(i);
        if(aA == 'a' || aA == 'A') {
           counta++;
           System.out.println(counta);
        }
    }
}