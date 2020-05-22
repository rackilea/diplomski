public Object getValueAt(int row, int column) {

        if(contents.length>row && contents[row].length>column)
        return contents[row][column];
        return null;//must solve this issue when object not found
    }