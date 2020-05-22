name := "Spark_Ignite_Project"

version := "0.1"

scalaVersion := "2.11.8"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.2.0"
libraryDependencies += "org.apache.ignite" % "ignite-core" % "2.2.0"
libraryDependencies += "org.apache.ignite" % "ignite-spring" % "2.2.0"
libraryDependencies += "org.apache.ignite" % "ignite-indexing" % "2.2.0"
libraryDependencies += "org.apache.ignite" % "ignite-log4j" % "2.2.0"


assemblyMergeStrategy in assembly := {
case PathList("META-INF", xs @ _*) => MergeStrategy.discard
case x => MergeStrategy.first
}