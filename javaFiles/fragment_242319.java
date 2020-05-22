// this will work, and it will update the database, but the user need to restart his client to view the edited row
public void btnSetReservationToUnactive() {
    TableObject tableObject = getSelectedObject();
    ReservationBean.setReservationAsUnactive(ReservationBean.getReservationByID(tableObject.getID()));

}

// this method will update the current clients view also, because it get the object were it originally came from.
// rather than getting a new object from the em.
public void btnSetReservationToUnactive() {
    TableObject tableObject = getSelectedObject();
    ReservationBean.setReservationAsUnactive(getReservationByIdFromTable(tableObject.getID()));

}

public Reservation getReservationByIdFromTable(int resID) {
    for (Reservation res : customer.getReservationCollection()){
        if (res.getID() == resID)
            return res;
    }

}