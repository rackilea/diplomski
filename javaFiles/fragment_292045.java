Scanner var = new Scanner(System.in);
int m;
long x=1; //for the factorial, we want to store in a long to combat data overflow
System.out.println("Type in your first number: ");
m = var.nextInt();
//if the input is odd we calculate its factorial
if (m%2==1){
    for (int i = 1;i<=m;i++)
        x*=i;
    System.out.println(m+"!: "+x);
}
else{
    System.out.println("1 is a divisor for "+m);
    System.out.println("2 is a divisor for "+m);
    if (m%3==0)
        System.out.println("3 is a divisor for "+m);
    //and so on for more divisors of m
}