switch (holdUserInput) {
    case 1:
        list.sort(Comparator.comparing(Realestate::getPrice));
        break;
    case 2:
        list.sort(Comparator.comparing(Realestate::getLocation));
        break;
    case 3:
        list.sort(Comparator.comparing(Realestate::getDescription));
        break;
    default:
        System.out.println("Program Ended \n");
        break;
}