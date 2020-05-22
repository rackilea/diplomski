@Suppress("UNCHECKED_CAST")
fun convertToJson(input: Map<String, Any>): JSONObject {
    val jsonObject = JSONObject()
    input.forEach { (key, value) ->
        value1 = if (value is Map<*, *>)
            convertToJson(value as Map<String, Any>)
        else
            value
        jsonObject.put(key, value1)
    }
    return jsonObject
}