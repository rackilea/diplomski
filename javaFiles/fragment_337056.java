private static boolean isLegalPosition(Coord position) {

        if ( position.row < 0 || position.row >= matrix.length ) {
            return false;
        }

        if ( position.col < 0 || position.col >= matrix[0].length ) {
            return false;
        }

        return matrix[position.row][position.col] != null;
    }