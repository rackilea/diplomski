String even = "";
String odd = "";

while(true){
    System.out.print("Enter number: ");
    int num = input.nextInt();
    if(num == 0) break;
    // even
    if(num % 2 == 0) even += num + " ";
    // odd
    else odd += num + " ";
}

System.out.println("Even\n" + even.trim().replace(" ", ","));
System.out.println("Odd\n" + odd.trim().replace(" ", ","));