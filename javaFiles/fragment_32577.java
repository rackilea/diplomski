boolean found = false;

for (Rectangle holder : placeHolder) {
    if (holder.intersects(comp.getBounds())) {

        JOptionPane.showMessageDialog(null, "Correct place !");
        GameStatus.points += 10;
        GameStatus.nrOfItems--;
        if (GameStatus.points == 50)
            GameStatus.level++;
        found = true;
        break;
    }
}
if (!found) {
    comp.setLocation(initialLoc);
}