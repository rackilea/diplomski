public void findPath(int size, int s) {

    // print the path and the distance of each vertex

    int j;
    // iterate to find the distances
    for (int i = 0; i < size; i++) {
        System.out.print("[" + distance[i] + "] ");

        // FIX #1: Remove this if statement
        if (i != 0) {

            System.out.print(s);
            j = i;
            // FIX #5: Use while instead of do
            do {

                // FIX #4: swap the order of these two lines
                j = path[j];
                // FIX #2: print j+1, not j
                // FIX #3: Instead of print, push onto a stack
                System.out.print(" <- " + j);

            } while (j != startVertex);

            // FIX #3: Put your pop-and-print loop here. It should not
            // involve i, and should end when the stack is empty, not
            // any other condition.
        }

        System.out.println();

        }
    }
}