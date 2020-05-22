import sbt._
import Keys._

object MainProjectBuild extends Build {
  lazy val main = Project(id = "main-project-id", base = file(".")) dependsOn(other)
  lazy val other = Project(id = "other-project-id", base = file("other-project"))
}