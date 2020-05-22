for(Occupant occupant : occupants){
    if(occupant instanceof Hazard){
        Hazard hazard = (Hazard) occupant; // now it's safe to cast
        double impact = hazard.getImpact();
        // do what you want with impact
    }
}