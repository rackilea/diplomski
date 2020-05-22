String txt = new JoinedText(
  " ",
  new Mapped<>(
    repo.languages(),
    lang -> String.format("#%s", lang.name())
  )
).asString();