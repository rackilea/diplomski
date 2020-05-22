final String regex = "[a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8}";
final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
for(int i=0;i<args.length;i++){
    Matcher matcher = pattern.matcher(args[i]);
    matcher.find(); // <- This line needed to be added
    contentCSVStr[i] = matcher.group();
}