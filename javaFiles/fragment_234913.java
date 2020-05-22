val whiteList = List(
  "b", "br", "ul", "ol", "li", "em", "h4", "h5", "hr", "pre", "sub", "sup"
)
def clean(raw: String): String = {
  def traverseAndClean(elem: Element): Unit = {
    if (!whiteList.contains(elem.tagName())) {
      elem.remove()
    } else {
      elem.attributes().forEach { attr =>
        val key = attr.getKey
        if (key != "dir") elem.removeAttr(key)
      }
      elem.children().iterator().forEachRemaining(traverseAndClean)
    }
  }
  val doc = Jsoup.parseBodyFragment(raw)
  doc.body().children().iterator().forEachRemaining(traverseAndClean)
  doc.body().html()
}

clean("my unsafe text")