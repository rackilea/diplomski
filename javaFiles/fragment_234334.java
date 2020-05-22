val content = Source.fromFile("file/text").filter(_.isDigit).map(_.toLong - '0').toList

val result = (0 to content.size - 13).foldLeft((List.empty[Long], -1l)){case (current @(_, curMax), next) => {
    val temp = content.drop(next).take(13)
    val tempVal = temp.reduce(_*_)
    if(tempVal > curMax) (temp, tempVal) else current
  }
}