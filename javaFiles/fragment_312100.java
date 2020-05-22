scala val regex = ".*/(.*)/(\\d{4}-\\d{2}-\\d{2}).txt".r
regex: scala.util.matching.Regex = .*/(.*)/(\d{4}-\d{2}-\d{2}).txt

scala> val s = "basedir/somedir/tmp/BLAH/2015-01-01.txt"
s: String = "basedir/somedir/tmp/BLAH/2015-01-01.txt"

scala> val regex(dir, date) = s
dir: String = "BLAH"
date: String = "2015-01-01"