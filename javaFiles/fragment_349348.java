Pattern pattern = Pattern.compile("^[\\d#]+$");
Matcher matcher = pattern.matcher(YOUR TEXT HERE);

if (matcher.find()) {
    System.out.println("matches!");
}