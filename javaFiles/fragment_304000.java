rdd.foreachPartition{iter =>
  // prepare connection
  Stuff.connect(...)
  // add elements
  iter.foreach(elem => Stuff.add(elem))
  // submit
  Stuff.commit()
}