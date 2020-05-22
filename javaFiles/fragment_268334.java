do    {
        System.out.println("type values for columns 1, 2, and 3 of line: " + counter);
        column1[counter] = Scan.nextLine();
        column2[counter] = Scan.nextLine();
        column3[counter] = Scan.nextDouble();
        //after typing out the data for this line, user can type 1 to go to the next line, or 2 to rewrite this line
        System.out.println("type 1 to continue, 2 to rewrite");
        check = Scan.nextInt();
        Scan.nextLine();
        if (check==1) {counter++;}else {}
}while (counter<3);