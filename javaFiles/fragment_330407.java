public void categorise() {
    for (Fighter fighter : fighters) {
        switch (fighter.getAgeGroup()) {
            case "senior":
                seniorResults.add(fighter);
                break;
            case "standard":
                standardResults.add(fighter);
                break;
            case "junior":
                juniorResults.add(fighter);
                break;
        }
    }
}