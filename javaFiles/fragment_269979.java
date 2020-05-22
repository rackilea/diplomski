case 6:
    System.out.println("Search");
    Employee employee1 = MenuMethods.userInputByName();
    Employee foundEmployee = Store.searchByName(employee1.getEmployeeName());

    if (foundEmployee != null) {
        System.out.println("Found employee!");
    } else {
        System.out.println("Not Found!");
    }

    break;