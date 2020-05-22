case class NameValueWithLag(name: String, value: Int, lag: Int)
val cnt = rdd.count() - 1

rdd.
    zipWithIndex.
    flatMap{case (x, i) => (0 to 1).map(lag => (i - lag, (i, x)))}.
    groupByKey.
    filter{ case (k, v) => k != cnt}.
    values.
    map(vals => {
        val sorted = vals.toArray.sortBy(_._1).map(_._2)
        if (sorted.length == 1) {
            NameValueWithLag(sorted(0).name, sorted(0).value, sorted(0).value)
        } else {
            NameValueWithLag(
               sorted(1).name, sorted(1).value,
               sorted(1).value - sorted(0).value
            )
        }
    })