public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Hur många nummer ska din lista bestå av?");
    int ListaLength = s.nextInt();
    Integer array[] = new Integer[ListaLength];
    for (int i = 0; i < ListaLength; i++) {     
        array[i] = s.nextInt();

    }
    for(int i : array){
        System.out.print(i+" ");
    }
    System.out.println("Skriv in numret du letar efter.");
    int num = s.nextInt();
    int index = Arrays.asList(array).indexOf(num);
    System.out.println(index);

}