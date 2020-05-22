lazy val root = (project in file("."))
  .settings(
    unmanagedSources in Compile ++=
      legacyJavaSources(baseDirectory.value.getParentFile / "JavaSourceDir1"),

    unmanagedSources in Compile ++=
      legacyJavaSources(baseDirectory.value.getParentFile / "JavaSourceDir2")
  )


def legacyJavaSources(dir: File): Vector[File] = {
  (dir * "*.java").get.toVector
}