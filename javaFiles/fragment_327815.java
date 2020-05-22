public static void main(String[] args) {
    Scanner cin=new Scanner(System.in);
    String input=cin.nextLine();
    String[] numbers = input.split("\\s");
    int max = Integer.parseInt(numbers[0]);
    for(int i=1; i<numbers.length; i++){
        int num=Integer.parseInt(numbers[i]);
        if(num>max) max=num;
    }
    System.out.println(max);
}