Map<String, String> replacements = Map.ofEntries(
        Map.entry("i", "e"), 
        Map.entry("e", "i")
);
String replaced = Pattern.compile("[ie]")
                         .matcher(yourString)
                         .replaceAll((match) -> replacements.get(match.group()));