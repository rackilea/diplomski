double max = 0;
int machine = 0;

for(int c = 0; c < excelMatrix.length; c++){
    double sum = 0;

    for(int r = 0; excelMatrix[c].length; r++){
        sum += excelMatrix[c][r];
    }

    if(max < sum){
        max = sum;
        machine = c;
    }
}