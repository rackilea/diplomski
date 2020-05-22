object XmlTagTruncationHelper {
    /**@param maxLines max lines to permit. If <0, means there is no restriction
     * @param maxTextCharacters max text characters to permit. If <0, means there is no restriction*/
    class Restriction(val maxTextCharacters: Int, val maxLines: Int) {
        var currentTextCharactersCount: Int = 0
        var currentLinesCount: Int = 0
    }

    @JvmStatic
    fun truncateXmlTag(xmlTag: XmlTag, restriction: Restriction): String {
        if (restriction.maxLines == 0 || (restriction.maxTextCharacters >= 0 && restriction.currentTextCharactersCount >= restriction.maxTextCharacters))
            return ""
        val sb = StringBuilder()
        sb.append("<").append(xmlTag.tagName)
        val numberOfAttributes = if (xmlTag.tagAttributes != null) xmlTag.tagAttributes!!.size else 0
        if (numberOfAttributes != 0)
            for ((key, value) in xmlTag.tagAttributes!!)
                sb.append(" ").append(key).append("=\"").append(value).append("\"")
        val numberOfInnerContent = if (xmlTag.innerTagsAndContent != null) xmlTag.innerTagsAndContent!!.size else 0
        if (numberOfInnerContent == 0)
            sb.append("/>")
        else {
            sb.append(">")
            for (innerItem in xmlTag.innerTagsAndContent!!) {
                if (restriction.maxTextCharacters >= 0 && restriction.currentTextCharactersCount >= restriction.maxTextCharacters)
                    break
                if (innerItem is XmlTag) {
                    if (restriction.maxLines < 0)
                        sb.append(truncateXmlTag(innerItem, restriction))
                    else {
//                    Log.d("AppLog", "xmlTag:" + innerItem.tagName + " " + innerItem.innerTagsAndContent?.size)
                        var needToBreak = false
                        when {
                            innerItem.tagName == "br" -> {
                                ++restriction.currentLinesCount
                                needToBreak = restriction.currentLinesCount >= restriction.maxLines
                            }
                            innerItem.tagName == "li" -> {
                                ++restriction.currentLinesCount
                                needToBreak = restriction.currentLinesCount >= restriction.maxLines
                            }
                        }
                        if (needToBreak)
                            break
                        sb.append(truncateXmlTag(innerItem, restriction))
                    }
                } else if (innerItem is String) {
                    if (restriction.maxTextCharacters < 0)
                        sb.append(innerItem)
                    else
                        if (restriction.currentTextCharactersCount < restriction.maxTextCharacters) {
                            val str = innerItem
                            val extraCharactersAllowedToAdd = restriction.maxTextCharacters - restriction.currentTextCharactersCount
                            val strToAdd = str.substring(0, Math.min(str.length, extraCharactersAllowedToAdd))
                            if (strToAdd.isNotEmpty()) {
                                sb.append(strToAdd)
                                restriction.currentTextCharactersCount += strToAdd.length
                            }
                        }
                }
            }
            sb.append("</").append(xmlTag.tagName).append(">")
        }
        return sb.toString()
    }
}