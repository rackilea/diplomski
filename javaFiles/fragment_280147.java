private int peopleInHotel=0;

public int getPeopleInHotel() {
    return peopleInHotel;
}

public void incrementIfConditionMet(Boolean personCheckedIn) {
    if (personCheckedIn){
         peopleInHotel++
    }
}