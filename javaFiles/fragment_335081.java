fun <KEY, VALUE> createMultimap(values: Collection<VALUE>, transformFunction: TransformFunction<VALUE, KEY>): Map<KEY, MutableList<VALUE>> {
    val tmpMap = HashMap<KEY, MutableList<VALUE>>()
    for (value in values) {
        if (value != null) {
            val key = transformFunction.transform(value)
            var valuesList: MutableList<VALUE>? = tmpMap[key]
            if (valuesList == null) {
                valuesList = mutableListOf()
                tmpMap.put(key, valuesList)
            }
            valuesList.add(value)

        }
    }
    return Collections.unmodifiableMap(tmpMap)
}