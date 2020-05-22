case "chapter":
    System.out.println("Are they chapter president? (y/n)");
    switch(s.nextLine()){
    case "y":
        totalPoints = chapterPres;
        break;
    case "n":
        totalPoints = chapterBoardMember;
        break;
    }
    break; // This was missing
case "regional":
    System.out.println("Are they regional president? (y/n)");
    switch(s.nextLine()){
    case "y":
        totalPoints = regionalPres;
        break;
    case "n":
        totalPoints = regionalExecutive;
        break;
    }
    break; // This was missing
case "international":
    System.out.println("Are they international president? (y/n)");
    switch(s.nextLine()){
    case "y":
        totalPoints = internationalPres;
        break;
    case "n":
        totalPoints = internationalExecutive;
        break;
    }
    break; // This was missing
case "n": break;