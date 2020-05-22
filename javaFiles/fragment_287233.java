final String input = "Rp.1.000.000.000";

int    value = 0;
String token = "Rp";

if (input.contains(token))
    value = Integer.parseInt(input.replaceAll("[^012456789]", ""));