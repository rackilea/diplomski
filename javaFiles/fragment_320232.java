@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    // here i am getting values 
    if (columnIndex==2){
        // i would like to do it here so that at column Index 2 has the datas from the array list 20 10 100 }
        if (rowIndex < data.size()) {
            return data.get(rowIndex);
        } else {
            return null;
        }
    }
    return super.getValueAt(rowIndex, columnIndex);
}