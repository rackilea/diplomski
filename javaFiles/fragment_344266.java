do {
    char addTbl = readString("Add Table?: (Y/N)").toUpperCase().charAt(0);
    if (addTbl == 'Y') {
        int newTableId = Table.getNumberOfTables() +1;
        int seats = readInt("Enter Table Seats", 30, 1);
        Table rt = new Table(newRestaurantId, restaurantName, restaurantLocation, newTableId, seats);
        restaurants.add(rt);
    }else{
        Restaurant r = new Restaurant(newRestaurantId, restaurantName, restaurantLocation);
        restaurants.add(r);   
    }
}while(addTble != 'N');