private final Random random = new Random();

public void rollInitBtnClicked() {
    List<Players> targets = playersTable.getItems();

    for (Players p : targets) {
        p.setRoll(random.nextInt(20));
        // set total ect...
    }

    // update table
    playersTable.refresh();
}