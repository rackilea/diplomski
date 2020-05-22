public static void main(String[] args) {
    int i = 0;
    Scanner input = new Scanner(System.in);
    while(input.hasNext() && i<1){  
        String nextLine = input.nextLine();
        System.out.println(nextLine);
        if(nextLine.equals("exit")){
            i++;
        }
    }
    input.close();
}