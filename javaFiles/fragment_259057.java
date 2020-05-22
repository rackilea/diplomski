public static main(String[] args) {
   if (args.length < 1) throw new IllegalArgumentException("missing path");
   generateHumanName(args[0]);
}

/**
 * Generates a male "human-ish" name from a text file of syllables.
 * @return String The male human name.
 */
private static String generateHumanName(String path) {
  try (FileReader reader = new FileReader(path)) {

  } catch (IOException e) {
    e.printStackTrace();
  }
  return null; // never called
}