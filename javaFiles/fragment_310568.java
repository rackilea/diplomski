case Some(map: List[Map[String, _]]) =>
     map.map(map => {map("name") -> 
     map("value") match {
     case s: String => s
     case i: java.lang.Number => i
     case unexpectedType => throw Exception(s"Unexpected type $unexpectedType")
   }.toString}).toMap