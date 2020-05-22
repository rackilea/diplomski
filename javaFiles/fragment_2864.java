int n = 1; // or 0
for (; n < parkinglot.length && parkinglot[n][0] != null; n++);
if (n < parkinglot.length) {
    populateParkingLotEntry(parkinglot, n);
} else {
    // No more slots left...
}