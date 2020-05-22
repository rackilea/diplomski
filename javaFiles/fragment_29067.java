name := "secret"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.0"

seq(com.github.siasia.WebPlugin.webSettings :_*)

seq(jrebelSettings: _*)

jrebel.webLinks <++= webappResources in Compile

resolvers ++= Seq(
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
    "Scala 2.10 support for rogue" at "https://github.com/mattpap/rogue/"
)

libraryDependencies ++= {
    val liftVersion = "2.5-M4"
    Seq(
      "com.foursquare" %% "rogue-field" % "2.0.0-beta22",
      "com.foursquare" %% "rogue-core" % "2.0.0-beta22",
      "com.foursquare" %% "rogue-lift" % "2.0.0-beta22",
      "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
      "net.liftweb"    %% "lift-mongodb-record" % "2.5-M4",
      "com.mongodb.casbah" % "casbah_2.9.0" % "2.2.0-SNAPSHOT",
      "org.specs2" %% "specs2" % "1.12.3" % "test"
     )
}

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container" artifacts (Artifact("javax.servlet", "jar", "jar")
  )
)

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container" artifacts (Artifact("jetty-webapp", "jar", "jar")
  )
) 

port in container.Configuration := 5555

EclipseKeys.withSource := true