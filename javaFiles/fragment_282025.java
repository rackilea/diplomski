override fun handleTag(
    opening: Boolean,
    tag: String,
    output: Editable,
    xmlReader: XMLReader?
) {
    class DeleteSpan

    if (!tag.equals("script", true)) {
        return
    }
    if (opening) {
        output.setSpan(DeleteSpan(), output.length, output.length, Spannable.SPAN_MARK_POINT)
    } else {
        val spans = output.getSpans(0, output.length, DeleteSpan::class.java)
        val lastSpan = spans[spans.size - 1]
        output.apply {
            delete(getSpanStart(lastSpan), getSpanEnd(lastSpan))
            removeSpan(lastSpan)
        }
    }
}