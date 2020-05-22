Scanner in = new Scanner (System.in);
    String n, score;

    System.out.println("Enter Faculty's Name:");
    n=in.nextLine(); //asking the user to incode his/her name

    System.out.println("Enter score:");
    score=in.nextLine(); //asking the user to incode score

    if ("ABCDE".contains(score.toUpperCase())) {
        if (score.equalsIgnoreCase("a"))//  4.50 to 5.00
            System.out.println("Remark: Outstanding");

        else if(score.equalsIgnoreCase("b"))// 4.00 to 4.49
            System.out.println("Remark: Very Satisfactory");

        else if(score.equalsIgnoreCase("c"))// 3.50 to 3.99
            System.out.println("Remark: Satisfactory");

        else if(score.equalsIgnoreCase("d"))//3.00 to 3.49
            System.out.println("Remark: Needs Improvement");

        else
            System.out.println("Remark: Poor");

    } else {
        if (Float.valueOf(score) >=4.50)//  4.50 to 5.00
        System.out.println("Remark: Outstanding");

        else if(Float.parseFloat(score) >=4.00 )// 4.00 to 4.49
            System.out.println("Remark: Very Satisfactory");

        else if(Float.parseFloat(score) >=3.50 )// 3.50 to 3.99
            System.out.println("Remark: Satisfactory");

        else if(Float.parseFloat(score) >=3.00 )//3.00 to 3.49
            System.out.println("Remark: Needs Improvement");

        else
            System.out.println("Remark: Poor");            
    }