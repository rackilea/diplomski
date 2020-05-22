System.out.print("Please enter a number:"); 
a=input.nextInt();

while (true) {
    System.out.println("Do you want to add more: [y/n]");
    ans=input.next().charAt(0);

    if (ans == 'n' || ans == 'N') break;
    if (ans == 'y' || ans == 'Y') {
        System.out.print("Please enter a number:"); 
        int c = input.nextInt();
        a += c;
        continue;
    } 
    System.out.println("Please enter a valid option: [y/n]");
    continue;
}

System.out.println("The result is :"+c);