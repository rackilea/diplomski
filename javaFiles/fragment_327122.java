override fun equals(other: Any?): Boolean{
    if (this === other) return true
    if (other?.javaClass != javaClass) return false

    other as PlaceCommand

    if (x != other.x) return false
    if (y != other.y) return false

    return true
}