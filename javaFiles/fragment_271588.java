import com.typesafe.sbt.packager.docker._

name := """test"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, DockerPlugin)

scalaVersion := "2.11.7"

// Configure Docker settings
maintainer in Docker := "eeproperty"

dockerExposedPorts := Seq(9000)
dockerRepository := Some("eeproperty")
dockerBaseImage := "frolvlad/alpine-oraclejdk8:latest"
dockerCommands := dockerCommands.value.flatMap {
  case cmd@Cmd("FROM", _) => List(cmd, Cmd("RUN", "apk update && apk --no-cache add bash shadow && usermod -s /bin/bash daemon && usermod -d /opt/docker/ daemon"))
  case other => List(other)
}

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false