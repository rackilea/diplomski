public void init(Reservation r) {
    this.reservation = r;
    labelCountry.setText(r.getClients().getFirst().getCountry());
    labelRoom.setText(Integer.toString(r.getRooms().size()));
    labelClient.setText(Integer.toString(r.getClients().size()));
}