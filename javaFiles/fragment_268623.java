return if (json.isJsonObject()) {
    val struct: T = context.deserialize(json, actualTypeOfT)
    ObjectType(expand = struct)
} else {
    val id = json.getAsLong()
    ObjectType(Id = id)
}