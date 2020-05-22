case class Address(resid: String)
case class Person(name: String, adr1: Address)

val people = Seq(
  ("one", Array(Person("hello", Address("1")), Person("world", Address("2"))))
).toDF("_id", "persons")

import org.apache.spark.sql.Row
people.as[(String, Array[Person])].map { case (_id, arr) => 
  (_id, arr.map { case Person(name, Address(resid)) => (name, resid) })
}