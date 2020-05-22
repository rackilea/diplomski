Scanner in = new Scanner(System.in);
    int month, day; String season = null;
    System.out.print("Please enter month and day: ");
    month = in.nextInt(); day = in.nextInt();
    if(1 <= month && month <= 3){
        season = "Winter";
        if((month == 3) && (21 <= day))
            season = "Spring";
    } else if (4 <= month && month <=6){
        season = "Spring";
        if((month == 6) && (21 <= day))
            season = "Summer";
    } else if (7 <=month && month <=9){
        season = "Summer";
        if((month == 9) && (21 <= day))
            season = "Fall";
    } else if (10 <= month && month <= 12){
        season = "Fall";
        if((month == 12) && (21 <= day))
            season = "Winter";
    }
    System.out.println(season);