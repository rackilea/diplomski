public void totalAdultGuests(){
    int totalGuests = 0;
    for(Integer guests : adGuestNum) {
        totalGuests += guests;
    }
    System.out.println("The number of total adults is " + totalGuests);
}