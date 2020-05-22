String str = s;
    HashMap<String, String> replacements = new HashMap<>();
    replacements.put("e've", "e have");
    replacements.put("I'm", "I am");
    replacements.put("hat's", "hat is");
    for (Map.Entry<String, String> entry: replacements.entrySet()) {
        str = str.replaceAll(entry.getKey(), entry.getValue());
    }