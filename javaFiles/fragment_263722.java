Source
  .fromFile("files/ChargeNames")
  .getLines
  .map { line =>
    //do stuff with line like
    line.replace('a', 'b')
  }
  .foreach(println)