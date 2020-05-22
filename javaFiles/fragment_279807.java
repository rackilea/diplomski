case class Range(low : Int, high :Int)
val ranges = Seq( Range(0,9), Range(10,19), Range(20,29));
val rangesDf = sc.parallelize(ranges, 2).toDF

case class Value(value : Int)
val values = Seq(Value(1), Value(5), Value(10), Value(14), Value(20))
val valuesDf = sc.parallelize(values, 2).toDF

val inRange = udf{(v: Int, low: Int, high : Int) => v >= low && v<= high}

rangesDf.join(valuesDf, inRange(valuesDf("value"), rangesDf("low"), rangesDf("high"))).show