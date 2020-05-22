public static List<String> LANGUAGES = {"js", "java", "html"};
public static List<String> LIBRARIES = {"jquery", "ember"};
public static List<String> BROWSERS = {"chrome", "safari", "mozilla"};
public static List<String> MAIL = {"gmail", "yahoo"};
public static List<String> EDITORS = {"vim", "vi", "notepad"};

private static Map<String, String> categories= new HashMap<>;
static {
      // build the above map:
      LANGUAGES.forEach(e -> categories.put(e, "languages"));
      LIBRARIES.forEach(e -> categories.put(e, "libraries"));
      ...
}

public static getType(String name) {
      return categories.get(name);
}