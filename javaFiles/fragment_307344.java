Scanner sc = new Scanner ( System.in );


    System.out.println("Enter the date: ");
    String temp = sc.nextLine();

    String day =temp.substring(6,7);
    String month = temp.substring(0, 5);
    String year = temp.substring(8, 12);

    System.out.println(day + "-" + month + "-" + year); //3-April-2013

    sc.close();