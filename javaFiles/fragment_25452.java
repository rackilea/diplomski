int a;
System.out.println("String length: " + input.length());
for(a = 0; ((a + 1) * 97) < input.length(); a++) {
    System.out.print("Substring at " + a + ": ");
    System.out.println(input.substring(a * 97, (a + 1) * 97));
    //other code here...
}