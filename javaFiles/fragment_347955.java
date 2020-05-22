fun <T> List<T>.addNulls(element: T, toSize: Int) : List<T> {
    val elementsToAdd = (toSize - size)
    return if (elementsToAdd > 0) {
        this + List(elementsToAdd) { element }
    } else {
        this
    }
}