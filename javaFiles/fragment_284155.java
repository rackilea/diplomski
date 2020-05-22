public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line;
    line = scanner.nextLine();
    for (int i=0; i<line.length(); i++){
        if (line.charAt(i)=='('){
            while (line.charAt(i)!=')'){
                i++;
                if(line.charAt(i)==' '){
                    // changed
                    line = line.substring(0, i) + "-space-" + line.substring(i+1, line.length());
                }
            }
        }
    }
    System.out.println(line);     
    scanner.close();
}