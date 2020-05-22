String text = "INCLUDES(ABC) EXCLUDES(ABC) EXCLUDES(ABC) INCLUDES(ABC) INCLUDES(ABC)";
Matcher matcher = Pattern.compile("\\w+\\(.*?\\)").matcher(text);

while (matcher.find()) {
    System.out.println(matcher.group());
}