// print "Line n"
System.out.print("Line " + (j+1) + ":");

for (int i = 0; i < lotto.length;i++){
    lotto[i] = r.nextInt(45)+1;                                                             
    out.append(lotto[i] + " ");
    // Print in the same line the numbers
    System.out.print(lotto[i] + " ");
}
// Print the new line
System.out.println();