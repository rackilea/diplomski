private static final Set<String> LANGUAGES_WITH_STANDALONE_CASE;

static {
    Set<String> set = new HashSet<>();
    set.add("ru");

    // add more languages which require LLLL-pattern (for example other slavish languages)
    LANGUAGES_WITH_STANDALONE_CASE = Collections.unmodifiableSet(set);
}

public static void main(String[] args) throws Exception {

    Locale locale = new Locale("en");

    DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern(
        LANGUAGES_WITH_STANDALONE_CASE.contains(locale.getLanguage()) 
          ? "LLLL" : "MMMM",
        locale
      );
    System.out.println(LocalDate.now().format(formatter));

    // ru => Февраль
    // en => February
}