package lambdascala;

import scala.Function1;

public class Function1WithLambdaBuilder<P1, R> {

  public static interface Function1LambdaApply<P1, R> {
    R apply(P1 p1);
  }

  private Function1LambdaApply<P1, R> lambda;

  private Function1<P1, R> function;

  public Function1WithLambdaBuilder(Function1LambdaApply<P1, R> lambda) {
    this.lambda = lambda;
    this.function = new Function1<P1, R> () {
      @Override
      public R apply(P1 p1) {
        return Function1WithLambdaBuilder.this.lambda.apply(p1);
      }
    };
  }

  public Function1<P1, R> getFunction() {
    return this.function;
  }

}