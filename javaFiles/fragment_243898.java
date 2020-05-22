...
for(int i=0;i<number.length;i++){
    number[i]=read.nextInt();
    if(number[i]%2==0)
        even.add(number[i]);
    else
        odd.add(number[i]);
}
System.out.println("Even number is " + even);
System.out.println("Odd number is " + odd);
...