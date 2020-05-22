String[] components;
// what used to be called pH1 is accessed by components[0];
boolean[] deletedPieces;
// initially set to all false
// contains true for segments that the user wants to delete, false otherwise

your outer loop here {
    // ask the user which piece to delete here
    remove = in.nextInt() - 1; // - 1 to account for array indices starting at 0

    deletedPieces[remove] = true;

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < total number of possible pieces; i++) {
        if(deletedPieces[i])
            // user wanted this piece deleted; do nothing
        else
            sb.append(components[i]);
    }

    removeIng = sb.toString();
}