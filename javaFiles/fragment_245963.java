UnaryOperator<String> operator = t -> {
String ipPatt = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

Pattern pattern = Pattern.compile(ipPatt );
Matcher matcher = pattern.matcher(t);
if (matcher.find()) {
    return matcher.group();
} else {
    return "0.0.0.0";
}

};
    List<String> myFilteredList = myList.stream().filter(predicate).collect(Collectors.toList());
    myFilteredList.replaceAll(operator);