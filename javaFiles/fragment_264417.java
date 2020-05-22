private static HashMap<String, String> animalNameTranslations;
  static {
    animalNameTranslations = new HashMap<String, String>();
    for (int i = 0; i < animalNames.length; i++) {
      animalNameTranslations.put(animalNameAbbreviations[i], animalNames[i])
    }
  }