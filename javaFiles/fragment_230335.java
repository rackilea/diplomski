private Label[] crewNameLabels;
private ImageView[] crewImageViews;

@Override
public void initialize(URL location, ResourceBundle resources) {
    crewNameLabels = new Label[] { crew1, crew2, crew3, crew4, crew5, crew6, crew7, crew8  };
    crewImageViews = new ImageView[] {
        commandOfficer,
        firstOfficer,
        commOfficer,
        engineOfficer,
        helmsman,
        navigator,
        medOfficer,
        nurse
    };
}

private final InvalidationListener crewUpdater = o -> {
    int newCrewSize = 0;
    if (ship != null) {
        List<Crew> crew = ship.getCrew();
        newCrewSize = ship.getCrew().size();
        if (newCrewSize > crewNameLabels.length) {
            newCrewSize = crewNameLabels.length;
        }
        for (int i = 0; i < newCrewSize; i++) {
            CrewMember c = crew.get(i);
            crewNameLabels[i].textProperty().bind(c.nameProperty());
            crewImageViews[i].imageProperty().bind(c.imageProperty());
        }
    }

    // unbind everything that has no corresponding CrewMember
    for (int i = newCrewSize; i < crewNameLabels.length; i++) {
        crewNameLabels[i].textProperty().unbind();
        crewNameLabels[i].setText("");
        crewImageViews[i].imageProperty().unbind();
        crewImageViews[i].setImage(null);
    }
};

private final InvalidationListener captainUpdater = o -> {
    CrewMember captain = null;
    if (ship != null) {
        captain = ship.getCaptain();
    }
    if (captain == null) {
        welcomeMsg.textProperty().unbind();
        welcomeMsg.setText("");
    } else {
        welcomeMessage.bind(Bindings.concat("Welcome, ", captain.nameProperty()));
    }
};

private Starship ship;

public void setShip(Starship ship) {
    if (this.ship != null) {
        // remove old listener when replacing the ship
        this.ship.getCrew().removeListener(crewUpdater);
        this.ship.captainProperty().removeListener(captainUpdater);
    }

    this.ship = ship;
    if (ship != null) {
        ship.getCrew().addListener(crewUpdater);
        ship.captainProperty().addListener(captainUpdater);
        shipName.textProperty().bind(ship.nameProperty());
    } else {
        shipName.textProperty().unbind();
        shipName.setText("");
    }

    // update content
    crewUpdater.invalidated(null);
    captainUpdater.invalidated(null);
}