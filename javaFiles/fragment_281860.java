case "Sep":
    case "Nov":
        System.out.println(month + " " + year + " has 30 days"); break;

    case "Feb":
    if(isLeapYear)
    {
        System.out.println(month + " " + year + " has 29 days");
    }
        else
    {
            System.out.println(month + " " + year + " has 28 days");}
    }