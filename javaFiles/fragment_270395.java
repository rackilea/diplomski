String regex = "([^,]+),\\h*((\\w+-shi),\\h*[^,]+)";;
String string = "19922 test ibaraki, hamari-shi, hamari 3456789";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(string);

if (matcher.matches()) {
    System.out.println(matcher.group(1)); // 19922 test ibaraki
    System.out.println(matcher.group(3)); // hamari-shi, hamari 3456789
    System.out.println(matcher.group(2)); // hamari-shi
}