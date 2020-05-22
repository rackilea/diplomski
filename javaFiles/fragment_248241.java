int[] array; 
Scanner sc = new Scanner(System.in);
System.out.println("How long is your array?");
int len = sc.nextInt();
while (len <= 0) {
    System.out.println("Arrays aren't negative, unless your's is " +
                "smaller then physically posible, try again");
    len = sc.nextInt(); 
}
array = new int[len];