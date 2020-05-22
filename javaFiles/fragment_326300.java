import java.time.LocalDate

val groupByLetter :List[(String, List[(LocalDate, Double)])] =
  List(("A", List((LocalDate.parse("2018-10-24"),1.0)
                 ,(LocalDate.parse("2018-10-22"),-2.1)
                 ,(LocalDate.parse("2018-10-10"),5.1)
                 ,(LocalDate.parse("2018-11-22"),2.2)
                 ,(LocalDate.parse("2018-11-10"),24.0)))
      ,("B", List((LocalDate.parse("2018-10-24"),1.0)
                 ,(LocalDate.parse("2018-10-22"),-2.1)
                 ,(LocalDate.parse("2018-10-10"),5.1)
                 ,(LocalDate.parse("2018-11-22"),2.2)
                 ,(LocalDate.parse("2018-11-10"),30.0))))

val dates = List("2018-10-24", "2018-10-22", "2018-10-30")

val filtered = groupByLetter.map{outerTpl =>
  (outerTpl._1, outerTpl._2.filter(innerTpl => dates.contains(innerTpl._1.toString)))
}
//List((A,List((2018-10-24,1.0), (2018-10-22,-2.1)))
//   , (B,List((2018-10-24,1.0), (2018-10-22,-2.1))))