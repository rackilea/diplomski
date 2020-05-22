lazy val foodTrainer = (project in file("food-trainer"))

lazy val foodModel = (project in file("food-model"))
  .dependsOn(foodTrainer)
  .settings(    
     resourceGenerators in Compile += Def.task {
       val log = streams.value.log
       val dest = (resourceManaged in Compile).value   
       IO.createDirectory(dest)
       runModuleMain(
         cmd = s"com.foo.bar.FoodTrainer $pathToImages ${dest.getAbsolutePath}",
         cp = (fullClasspath in Runtime in foodTrainer).value.files,
         log = log
       )             
      Seq(dest / "model.bin")
    }

def runModuleMain(cmd: String, cp: Seq[File], log: Logger): Unit = {
  log.info(s"Running $cmd")
  val opt = ForkOptions(bootJars = cp, outputStrategy = Some(LoggedOutput(log)))
  val res = Fork.scala(config = opt, arguments = cmd.split(' '))
  require(res == 0, s"$cmd exited with code $res")
}