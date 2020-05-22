import lambdascala.Function1WithLambdaBuilder;
import lambdascala.Function2WithLambdaBuilder;
import scala.Function1;
import scala.Function2;
import java.util.List;

public class LambdaTry {

  public static void main() {

    Function1<List<Long>, List<Long>> changeNothing =
      new Function1WithLambdaBuilder<List<Long>, List<Long>>(
        // your lambda
        (List<Long> list) -> list
      ).getFunction();

    Function1<Integer, Integer> add2 =
      new Function1WithLambdaBuilder<Integer, Integer>(
        // your lambda
        (Integer i) -> i + 2
      ).getFunction();

    Function2<Integer, Integer, Integer> add =
      new Function2WithLambdaBuilder<Integer, Integer, Integer>(
        // your lambda
        (Integer i, Integer j) -> i + j
      ).getFunction();

    System.out.println(add2.apply(12));

    System.out.println(add.apply(12, 24));

  }

}