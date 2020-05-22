public void set(int row, int column, double val) {

    DataEntry temp = new DataEntry(row, column, val);
    for (int i = 0; i < data.size(); i++)
        if (data.get(i).getRow() == row && data.get(i).getColumn() == column) {
            data.set(i, temp);
            return;
        }
    }
    data.add(temp);
}