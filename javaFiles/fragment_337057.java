private static Integer findMax(Coord currPosition, int currDepth,
            int currSum) {

        // Recursion end: if we reached a depth of 10, we have the maximum at
        // the current position

        if (currDepth == MAX_DEPTH) {
            return currSum;
        }

        // Find the greatest number in all four directions. We start with an
        // unknown Max value.

        Integer currMax = null;
        for (Coord direction : directions) {

            Coord newPos = currPosition.newPosition(direction);

            // If the position is legal (inside the matrix and not visited),
            // explore it by adding depth, and adding the current matrix
            // value to the accumulated.
            if (isLegalPosition(newPos)) {

                // Save the value at the new position, and mark it as visited.
                int matrixValue = matrix[newPos.row][newPos.col];
                matrix[newPos.row][newPos.col] = null;

                Integer newMax = findMax(newPos, currDepth + 1, currSum + matrixValue);

                // Restore the value in the current matrix position so that
                // upper level recursions don't think it's visited.
                matrix[newPos.row][newPos.col] = matrixValue;

                // Calculate the new max. If this is the first legal path, use
                // it. Otherwise check which one is greater.
                if (newMax != null) {
                    currMax = (currMax == null) ? newMax
                            : (newMax > currMax ? newMax : currMax);
                }
            }
        }

        return currMax;
    }