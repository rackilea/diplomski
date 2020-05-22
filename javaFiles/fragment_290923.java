public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new FileInputStream("input.txt"));
    printIntArray(scanner);
}

public static void printIntArray(Scanner file) {
    List<Integer> list = new ArrayList<Integer>();
    while (file.hasNext()) {
        String[] tokens = file.nextLine().replaceAll("\\D", ",").replaceAll(",+", ",").split(",");
        for (String token : tokens) {
            if(!token.equalsIgnoreCase("")){
                list.add(Integer.parseInt(token));                  
            }
        }
    }

    for (Integer num : list) {
        System.out.println(num);
    }

}