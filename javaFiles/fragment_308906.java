lazy val settingsForMessageGeneration =
  ((test in Test) <<= (test in Test) dependsOn(messageGenerationCommand)) ++
  ((compile in Compile) <<= (compile in Compile) dependsOn(messageGenerationCommand)) ++
  (messageGenerationCommand <<= messageGenerationTask) ++
  (sourceGenerators in Compile += messageGenerationTask.taskValue)

lazy val messageGenerationCommand = TaskKey[scala.collection.Seq[File]]("gen-messages")

lazy val messageGenerationTask = (
  sourceManaged,
  fullClasspath in Compile in messageGenerator,
  runner in Compile in messageGenerator,
  streams
) map { (dir, cp, r, s) =>
  lazy val f = getFileTree(new File("./subProjectWithMsgSources/src/")).filter(_.getName.endsWith("messages.json"))

  def gen(sources: Set[File]): Set[File] = {
    sources.foreach({ te =>
      val messagePackagePath = te.getAbsolutePath().replace("messages.json", "msg").replace("./", "")
      val messagePath = te.getAbsolutePath().replace("./", "")
      val fi = new File(messagePackagePath)
      if (!fi.exists()) {
        fi.mkdirs()
      }

      val ar = List("-d", messagePackagePath, messagePath)
      toError(r.run("com.my.MessageClassGenerator", cp.files, ar, s.log))
    })
    getFileTree(new File("./subProjectWithMsgSources/src/"))
      .filter(_.getName.endsWith("/msg/*.java"))
      .to[scala.collection.immutable.Set]
  }
  val func = FileFunction.cached(s.cacheDirectory / "gen-messages", FilesInfo.hash) { gen }
  func(f.toSet).toSeq
}