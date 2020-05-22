@Override
public String toString() {
    stringedMat = "";

    for(int i = 0; i < mat.length; i++) {
        for(int j = 0; j < mat.length; j++) {
            if(j != (mat.length - 1)) {
                stringedMat += (mat[i][j] + " ");
            }else{
                stringedMat += mat[i][j];
            }
        }
        stringedMat += "\n";
    }

    return stringedMat;
}