val source = Source.fromFile(filename).getLines

// take every first word of each line as key and concatenate the
// pronunciations of each line as value and store this in table_1

val table1: Map[String, String] = source.map { line => 
                                                  val words = line.split(" ")
                                                  (words.head, words.drop(1).mkString)
                                              }
                                        .toMap

// loop through the values of table_1 and add only the values 
// to string_1 that are not numeric values; this new string 
// will now be the value of table_2 with the key still remaining 
// as the word

val table2 = table1.map { case (key, value) => 
                              val string_1 = value.toCharArray
                                                  .filter(!_.isDigit)
                                                  .mkString
                              (key, string_1)
                        }
                    .toMap

// -loop through the reversed string and keep adding the 
// values to string_2 until you encounter a vowel.
// -now you add this new string to table_3 as values with 
//the same words as before as keys

val table3 = table2.map { case (key, value) =>
                              val string_2 = value
                                           .reverse
                                           .takeWhile("AEIOU".indexOf(_) == -1)
                              (key, string_2 + value.charAt(value.length - 1 - string_2.length))
                        }
                  .toMap

val first_word = "CAT"
val second_word = "xx"

if (table3.get(first_word).isDefined && table3.get(second_word).isDefined) {

    Left(table3.get(first_word).get == table3.get(second_word).get)

} else {

    Right(List())
}