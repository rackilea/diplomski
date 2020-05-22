translator = DEFAULT 
while (chunks of input remain) {
  chunk = GetNextChunkOfInput // a line, paragraph, etc.
  new_translator = ScanChunkForStateChange(chunk, translator)
  if (new_translator != null) translator = new_translator // found a state change!
  print(translator.Translate(chunk))  // use the translator on the chunk
}