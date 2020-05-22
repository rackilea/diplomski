List("a", "b", "cd") ++
  (for{
    myMap <- myListOfMaps  // -> List(Map(studentId -> 1234, status -> active), Map(studentId -> 5678, ...     
    (k, v) <- myMap        // -> List((studentId, 1234), (status, active), ..
  } yield List(k, v))      // -> List(List(studentId, 1234), List(status, active), ..
  .flatten