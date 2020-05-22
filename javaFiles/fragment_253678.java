fun <T> List<T>.takeProportion(prop: Double): List<T> {
    if (prop < 0 || prop > 1)
        throw IllegalArgumentException("prop ($prop) must be between 0 and 1")
    val result = ArrayList<T>()
    var tally = 0.5
    for (i in this) {
        tally += prop
        if (tally >= 1.0) {
            result += i
            tally -= 1
        }
    }
    return result
}