public static void main(String[] args) {

    int lng = 10;
    int [] line = new int[lng];
    Scanner scanner = new Scanner(System.in);
    for(int i=0;i<lng;i++){
        line[i]=scanner.nextInt();
    }
    System.out.println(Arrays.toString(line));
}