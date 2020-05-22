private void airplaneSeatConstructorFirstClass(Airplane airplane, int numberOfSeats)
{
            for (int x = 0; x < numberOfSeats; x++) {
                airplane.getSeats()[x].setOccupied(false);
                airplane.getSeats()[x].setFirstClass(true);
                airplane.getSeats()[x].setBusinessClass(false);

                if ((x % 4) == 0 || (x % 4) == 3) {
                    airplane.getSeats()[x].setWindowseat(true);
                    airplane.getSeats()[x].setAisleSeat(false);
                } else {
                    airplane.getSeats()[x].setAisleSeat(true);
                    airplane.getSeats()[x].setWindowseat(false);
                }
            }
}

private void airplaneSeatConstructorBussinessClass(Airplane airplane, int numberOfSeats)
{
    for (int x = 0; x < numberOfSeats; x++) {
                airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setBusinessClass(true);
                airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setFirstClass(false);
                airplane.getSeats()[airplane.getNumberOfSeatsPerClass()[0] + x].setOccupied(false);
            }
}