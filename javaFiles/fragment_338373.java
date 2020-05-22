val main = play.Project(appName, appVersion, appDependencies).settings(
  // Add your own project settings here      
  testOptions in Test ~= { args =>
    for {
      arg <- args
      val ta: Tests.Argument = arg.asInstanceOf[Tests.Argument]
      val newArg = if(ta.framework == Some(TestFrameworks.JUnit)) ta.copy(args = List.empty[String]) else ta
    } yield newArg
  }
)