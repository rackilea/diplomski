public Object getValueAt (int rowIndex, int columnIndex) {

    // if it's the column with the 'row age', calculate the age and return it
    long rowAgeMs = System.currentTimeMs() - getCreationTime(rowIndex);

   // return the age in milliseconds, or a date, or a formatted time string 
}