Pattern p = Pattern.compile("Joe|Jasha");
boolean found = false;
for (String s : person) {
    if (p.matcher(s).find()) {
        found = true;
        break;
    }
}