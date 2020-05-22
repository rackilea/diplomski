private fun parseCode(msg: String): String {
       var upToNCharacters: String? = null
    try {
        var message = msg
        var part = arrayOf<String>()
        try {
            part = message.split("(?<=\\D)(?=\\d)".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        message = message.replace("FLAG", "")

        upToNCharacters = part[1].substring(0, Math.min(part[1].length, 6))
        Log.i("---->", upToNCharacters)
    } catch (e: Exception) {
    }
    return upToNCharacters!!
}