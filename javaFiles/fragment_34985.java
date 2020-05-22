public static void fillHadamard (int mat[][])
{
    fillHadamard(mat, 0,0,mat.length, 1); //overloading, assuming mat.length is pow of 2 
}
private static void fillHadamard (int [][] mat, int top, int left, int size, int sign)
{
    if (size == 1)
        mat[top][left] = sign;
    else
    {
       fillHadamard (mat, top, left, size/2, sign);
       fillHadamard (mat, top+size/2, left, size/2, sign);
       fillHadamard (mat, top, left+size/2, size/2, sign);
       fillHadamard (mat, top+size/2, left+size/2, size/2, (-1)*sign);
    }
}