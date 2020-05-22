// 10 lines
for(int i = 10; i >= 0; i--){

    int j = 0; 

    // Print 'X's (10 - i of them)
    for(; j < i; j++)
        System.out.print("X");

    // Print 'Y's (i of them)
    for(; j < 10; j++)
        System.out.print("Y");

    System.out.println();
}