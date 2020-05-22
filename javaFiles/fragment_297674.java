// String[] row = new String[preguntasArray.length];
for (int i=0; i<preguntasArray[0].length; i++) {
    String[] row = new String[preguntasArray.length];
    for (int j=0; j<preguntasArray.length; j++) {
        row[j]= preguntasArray[j][i];
        Log.d("row1values",row[0]);
    }
    pregsAl.add(i, row);
}