Source
  .fromFile("files/ChargeNames")
  .getLines
  .foreach { line =>
    //do stuff with line like
    println(line.replace('a', 'b'))
  }