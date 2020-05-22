Matrix distanceMatrix[][] = new Matrix[sourceLength][targetLength];

for (int row = 1; row < sourceLength; row += 1) {
    distanceMatrix[row][0] = new Matrix(        // The error is marked at this line.
        distanceMatrix[row - 1][0].cost + option.getDeletionCost(), //actually it occurs here
        row - 1,
        0
    );
}