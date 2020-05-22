int rows = 6;
int columns = 5;

int i,j;

int[][] myArray =  new int[rows][columns];



for (i=0; i<rows; i++) {
    for (j=0; j<columns; j++) {
         myArray[i][j] = i*j;
    }
}

try {
FileOutputStream out = new FileOutputStream("outputDat");
ObjectOutputStream oout = new ObjectOutputStream(out);

for (i=0; i<rows; i++) {
    for (j=0; j<columns; j++) {
         oout.writeShort(myArray[i][j] & 0xFFFF); // Edited this line!
    }
}

oout.close();
} catch (Exception ex) {
    ex.printStackTrace();
}