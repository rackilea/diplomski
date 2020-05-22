public static List<String> readNLinesOfInput(int lines2Read){
    List<String> inputs = new ArrayList<String>();
    try (Scanner sc = new Scanner(System.in)) { 
        while(inputs.size() < lines2Read) {
            System.out.println("Enter the "+(inputs.size()+1)+" line: ");
            String line = sc.nextLine();
            if("".equals(line)){
                System.out.print("Empty lines a not allowed. ");
                continue;
            }
            inputs.add(line);
        }
    }
    return inputs;
}