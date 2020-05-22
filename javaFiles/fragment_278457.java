int sum = 2;
for (int i = 3; i <= number; i++) {
    fibonacci = fibo1 + fibo2; 
    fibo1 = fibo2;
    fibo2 = fibonacci;
    sum = sum + fibonacci;
}
System.out.println("Sum: " +sum); //print before return fibonacci