name := "project"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  filters,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
  "com.mysema.querydsl" % "querydsl-jpa" % "3.3.4",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "net.sf.opencsv" % "opencsv" % "2.3"
)     

play.Project.playJavaSettings

playJavaSettings ++ QueryDSLPlugin.queryDSLSettings

val current = project.in(file(".")).configs(QueryDSLPlugin.QueryDSL)

QueryDSLPlugin.queryDSLPackage := "models"

play.Keys.lessEntryPoints <<= baseDirectory { base =>
   (base / "app" / "assets" / "stylesheets" * "*.less")
}