while (varTime < 10) {
    varTime += 1;
    System.out.println(varTime);
    distance = fallingDistance(varTime);
    distanceCalc += distance;
    JOptionPane.showMessageDialog(null, "The distance travelled is " + distanceCalc + " meters.");
}