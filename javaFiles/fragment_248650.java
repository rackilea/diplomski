public String toString()
{

    String str = "";

    for (int i = 0 ; i<this.rows ; i ++ ){
        for (int j = 0 ; j < this.cols ; j++){
            str += mat[i][j]+"\t";
        }
        str += "\n";
    }
    return str;
}