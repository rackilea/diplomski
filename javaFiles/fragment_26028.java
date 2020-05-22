public Matrix4f mul(Matrix4f r) {
Matrix4f res = new Matrix4f();
for(int i = 0; i < 4; i++)
{
    for(int j = 0; j < 4; j++)
    {
        res.set(i, j, m[i][0]*r.get(0, j) + 
                      m[i][1]*r.get(1, j) +
                      m[i][2]*r.get(2, j) +
                      m[i][3]*r.get(3, j));
    }
}

return res;

}