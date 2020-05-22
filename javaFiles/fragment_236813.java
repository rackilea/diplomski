public void dominantEigenV()
{
  for (int k=1; k<kMax; k++)
  {
    alpha0=result.getE_val();
    x0=result.getE_vec();
    result.setE_vec(A.multiply(result.getE_vec().toColumnMatrix()).getColumn(0));
    result.setE_val(((Vector)x0.toRowMatrix().multiply(result.getE_vec())).get(0));
    result.setE_vec(result.getE_vec().transform(Vectors.asDivFunction(result.getE_vec().euclideanNorm())));
    System.out.println("k:"+k + ",xk:" + this.x0 + ",xkp1:" + this.result.getE_vec() + ",alpha_k:"  + this.alpha0 + ",alphak_1:" + this.result.getE_val());
    if (Math.abs(result.getE_val() - alpha0) < tolerance)
    {
        break;
    }
  }
}