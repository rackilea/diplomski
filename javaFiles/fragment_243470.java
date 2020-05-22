final String regex = "<option(.*?)\\s+(disabled)\\s+(selected)\\s+(hidden)>";
final String string = "<option value=\"\" disabled selected hidden>\n\n"
     + "<option value=\"adfsa\" disabled selected hidden>\n\n"
     + "<option value=\"111\" disabled selected hidden>\n\n\n\n";
final String subst = "<option $1 $2=\"disabled\" $3=\"disabled\" $4=\"hidden\">";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll(subst);

System.out.println("Substitution result: " + result);