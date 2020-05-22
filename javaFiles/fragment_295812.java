boolean found = false;
while(!found && in.hasNext()) {
    String line = in.nextLine();
    if (line.contains(input)) {
        found = true;
        popUp1 pu1 = new popUp1();
        pu1.setVisible(true);
    }
}

// If we've gone over the entire file and still not found anything:
if (!found) {
    popUp2 pu2 = new popUp2();
    pu2.setVisible(true);
}