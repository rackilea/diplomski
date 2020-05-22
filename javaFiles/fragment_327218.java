for (int row = 0; row < WIDTH_EASY; ++row) {
    for (int column = 0; column < WIDTH_EASY; ++column) {
        getCurrentState().board_elements[row][column] = new BoardElement();
        getCurrentState().board_elements[row][column].max_connecting_bridges = Integer.parseInt(debug_board_state[row][column]);
        getCurrentState().board_elements[row][column].row = row;
        getCurrentState().board_elements[row][column].col = column;
        if (getCurrentState().board_elements[row][column].max_connecting_bridges > 0) {
            getCurrentState().board_elements[row][column].is_island = true;
        }
    }
}