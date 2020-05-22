fun String.splitByPattern(pattern: String): List<String> {

    val indices = Regex(pattern).findAll(this).map{ listOf(it.range.start, it.range.endInclusive) }.flatten().toMutableList()

    var lastIndex = 0
    return indices.mapIndexed { i, ele ->

        val end = if(i % 2 == 0) ele else ele + 1 // magic

        substring(lastIndex, end).apply {
            lastIndex = end
        }
    }
}