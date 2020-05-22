do {
    Depot depot1;
    Depot depot2;
    //Your code for the menu, e.g. selecting what the user wants to do
    switch (option) {
        case 1 :
            if (depot1 == null) {
                depot1 = new Depot()
                //Do what you want to do with your depot
            } else if (depot2 == null) {
                depot2 = new Depot()
                //Same as above
            }
            break;
            //Rest of the switch statement
    }
} while (option != 3)