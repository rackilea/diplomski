public static void main(String[] args) {

    int lng = 10;
    String [] line = new String[lng];
    Scanner scanner = new Scanner(System.in);
    for(int i=0;i<lng;i++){
        line[i]=scanner.nextLine();
    }
    System.out.println(Arrays.toString(line));
}