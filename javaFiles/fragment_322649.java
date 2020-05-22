val reader = new InputStreamReader(file)
val config = try {
  ConfigFactory.parseReader(reader)
} finally {
  reader.close()
}