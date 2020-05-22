scala> val str = "basedir/somedir/tmp/BLAH/2015-01-01.txt"
str: String = basedir/somedir/tmp/BLAH/2015-01-01.txt

scala>  val regex = ".*/(\\d{4}-\\d{2}-\\d{2}).txt".r
regex: scala.util.matching.Regex = .*/(\d{4}-\d{2}-\d{2}).txt

scala>
     |     str match {
     |       case regex(date) => Some(date)
     |       case _ => None
     |     }
res21: Option[String] = Some(2015-01-01)