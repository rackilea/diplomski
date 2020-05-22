for (int column = 0; column < width; column++) {
    for (int row = 0; row < height; row++) {
        if (array[column][row] == 1) {
            list.append(column);
            break;  // move on to the next column because we don't care what's 
                    // left in this column as we already found our '1'