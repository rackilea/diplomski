int col1 = 1; // assign a valid column index
int fields = 0;

for (String line : lines) {

    if (array[col1].equals("")) {
        // System.out.println("Cell is blank");
        break;
    } else {
        // System.out.println(array[col1].toString());
        fields++;
    }
}

if (fields < headers.size()) {
    msg = "Invalid file";
    // headers[fields] is the name of the column with the empty cell 
}