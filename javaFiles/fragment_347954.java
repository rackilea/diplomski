val list1 = listOf("a", "b", "c")
    val list2 = listOf("a", "B", "c")

    val diff : Map<Int, String> = list1.withIndex()
        .zip(list2) { (idx,a), b -> if (a != b) idx to "$a != $b" else null}
        .filterNotNull().toMap()