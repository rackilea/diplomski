object DateTimeParser {

  val NameMask = "DATETIME"

  case class dateParts(times: scala.collection.immutable.List[Date], text: String, line: Int, position: Int)

  def apply(emailBody: String): Seq[dateParts] = parseEmail(emailBody)

  def normalizeBody(emailBody: String, parser: PrettyTimeParser): String = {
    val dates: Seq[dateParts] = parseEmail(emailBody, parser)
    val dateStrings: Seq[String] = dates map (_.text)
    val dateMap: Map[String, String] = dateStrings.map((_, NameMask)).toMap

    dateMap.foldLeft(emailBody) { case (cur, (regex, _)) => cur.replaceAll(regex, NameMask) }
  }

  def parseEmail(emailBody: String, parser: PrettyTimeParser): Seq[dateParts] = {
    val parsed: Seq[DateGroup] = parser.parseSyntax(emailBody).asScala.toList
    parsed
      .map(curr => dateParts(curr.getDates.asScala.toList, curr.getText, curr.getLine, curr.getPosition))
  }
}