String input = "";
int distance = 100;
int numberOfHits = 0;
int hit = 0;

while (distance > 0) {
    numberOfHits++;//increasing the nuber of hits
    input = JOptionPane.showInputDialog("distance to hole " + distance + " Which club (1-putting), 2-(pitching) or 3-iron");
    switch (input) {//if you don't know switch you coukd use if-else
        case "1":
            Random roll = new Random();
            hit = roll.nextInt(6);//a random int netween 0-5
            JOptionPane.showMessageDialog(null, "you hit ..." + hit + "m");
            distance -= hit;//sets the new distance to the old distance subtracted the hit
            distance = Math.abs(distance);//if distance is negative make it positive
            break;
        case "2":
            roll = new Random();
            hit = roll.nextInt(31);
            JOptionPane.showMessageDialog(null, "you hit ..." + hit + "m");
            distance -= hit;
            distance = Math.abs(distance);
            break;
        case "3":
            roll = new Random();
            hit = roll.nextInt(151);
            JOptionPane.showMessageDialog(null, "you hit ..." + hit + "m");
            distance -= hit;
            distance = Math.abs(distance);
            break;
    }
}
//when we are out of the loop the distance is zero
JOptionPane.showMessageDialog(null, "Congratulations, you took " + numberOfHits + " shots.");