@TypeConverter
fun getListOfLongs(data: String?): List<Long> {
    if (data == null) {
        return Collections.emptyList()
    }
    val listType = object : TypeToken<List<Long>>() {}.type

    return gson.fromJson("[$data]", listType)
}

@TypeConverter
fun convertListToString(ids: List<Long>?): String? {
    if (ids == null) return null
    var idsString = gson.toJson(ids)
    idsString = idsString.replace("]", "")
    idsString = idsString.replace("[", "")
    return idsString
}