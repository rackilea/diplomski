val a = ("1,3,5,7,11,13,15,17,21,23,25,27,29,33,35")
val nonBreakingRanges = a.split(',')
    .map { it.toLong() }
    .let { list ->
        var lastRange = mutableListOf<Long>()
        list.map {
            val previousElement = lastRange.lastOrNull() ?: it
            if (it == previousElement + 2) {
                lastRange.add(it)
            } else {
                lastRange = mutableListOf(it)
            }
            lastRange
        }.distinct()
    }