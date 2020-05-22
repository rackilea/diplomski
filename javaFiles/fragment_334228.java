while (true) {
    if (holdUserInput == 1) {
        list.sort(Comparator.comparing(Realestate::getPrice));
        break;
    } else if (holdUserInput == 2) {
        list.sort(Comparator.comparing(Realestate::getLocation));
        break;
    } else if (holdUserInput == 2) {
        list.sort(Comparator.comparing(Realestate::getDescription));
        break;
    } else {
        System.out.println("Program Ended \n");
        break;
    }// end else statement
}