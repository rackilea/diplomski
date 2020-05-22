parcel.writeIntList(files)
files = parcel.createIntList()

fun Parcel.writeIntList(input:List<Int>) {
    writeInt(input.size) // Save number of elements.
    input.forEach(this::writeInt) // Save each element.
}

fun Parcel.createIntList() : List<Int> {
    val size = readInt()
    val output = ArrayList<Int>(size)
    for (i in 0 until size) {
        output.add(readInt())
    }
    return output
}