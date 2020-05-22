try (InputStream is = MCVE.class.getResourceAsStream("/text/male_human_name_syllables.txt")) {
  if (null == is) {
    throw new FileNotFoundException("/text/male_human_name_syllables.txt");
  }
  try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
    // do stuff here
  }
}