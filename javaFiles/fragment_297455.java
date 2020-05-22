public static String findSeason(int month, int day) { 
    switch (month) {
        case 1: // January - Same season; Fall through to next case
        case 2: // February
            return "Winter";
        case 3: // March
            // Season change - check day of month
            return (day <= 20 ? "Winter" : "Spring");
        /* The rest of your cases here */