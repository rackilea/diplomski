while ( choice == 1 ) {
    int val = -2;
    System.out.println( "Enter a homework grade. Press -1 when finished" );
    while (val != -1) {
        val = input.nextInt();
        homeworkGrades += val;
    }
    System.out.println("Total for homework grades is " + homeworkGrades );
}