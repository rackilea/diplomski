public Consumer<EigenDecomp> dominantEigenV = 
  ei->IntStream.range(1, kMax)
  .peek(k->
    ((Consumer<EigenDecomp>)e->ei.alpha0=ei.result.getE_val())
      .andThen(e->x0=ei.result.getE_vec())
      .andThen(e->ei.result.setE_vec(A.multiply(ei.result.getE_vec().toColumnMatrix()).getColumn(0)))
      .andThen(e->ei.result.setE_val(((Vector)ei.x0.toRowMatrix().multiply(ei.result.getE_vec())).get(0)))
      .andThen(e->ei.result.setE_vec(ei.result.getE_vec().transform(Vectors.asDivFunction(ei.result.getE_vec().euclideanNorm()))))
      .andThen(e->System.out.println(e.toString(k)))
      .accept(ei)
     ).allMatch(k->Math.abs(ei.result.getE_val()-ei.alpha0) > ei.tolerance);

public String toString(int k)
{
    return "k:"+k + ",xk:" + this.x0 + ",xkp1:" + this.result.getE_vec() + ",alpha_k:"  + this.alpha0 + ",alphak_1:" + this.result.getE_val();
}