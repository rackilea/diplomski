private Starship ship;

public void setShip(Starship ship) {
    this.ship = ship;
}

private void setAll(String user) {
    ship.setCaptain(new CrewMember(user));

    ship.getCrew().setAll(Stream.generate(() -> new CrewMember(user))
                                .limit(8)
                                .toArray(CrewMember[]::new));
}