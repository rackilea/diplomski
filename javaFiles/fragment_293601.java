package lambdascala;

import scala.Function2;

public class Function2WithLambdaBuilder<P1, P2, R> {

  public static interface Function2LambdaApply<P1, P2, R> {
    R apply(P1 p1, P2 p2);
  }

  private Function2LambdaApply<P1, P2, R> lambda;

  private Function2<P1, P2, R> function;

  public Function2WithLambdaBuilder(Function2LambdaApply<P1, P2, R> lambda) {
    this.lambda = lambda;
    this.function = new Function2<P1,P2, R> () {
      @Override
      public R apply(P1 p1, P2 p2) {
        return Function2WithLambdaBuilder.this.lambda.apply(p1, p2);
      }
    };
  }

  public Function2<P1, P2, R> getFunction() {
    return this.function;
  }

}