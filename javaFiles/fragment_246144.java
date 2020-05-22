for (int x = cell.getGridX() - 1; x >= 0; ;) {
    if (compareCells(cell, getCell(x, cell.getGridY()))) {
        --x;
        ++matches[0];
        continue;
    }
    break;
}