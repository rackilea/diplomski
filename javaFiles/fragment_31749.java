private boolean reserveSeat(int selectedRow, int selectedSeat) {
    if (show.isSeatReserved(selectedRow, selectedSeat)) {
        return false;
    } else {
        show.reserveSeat(selectedRow, selectedSeat);
        setRowNumber(selectedRow);
        setSeatNumber(selectedSeat);

        return true;
    }
}