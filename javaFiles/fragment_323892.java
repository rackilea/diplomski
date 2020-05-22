val allLanguages = play.api.Play.current.plugin[MessagesPlugin].get.api.messages
val allValues =
  for {
    (_, oneLangage) <- allLanguages
    values <- oneLangage.values
  } yield values