String s = "It is very nice in summer and in summer time we swim, run, tan";
List<String> resultList = new ArrayList<String>();
Pattern regex = Pattern.compile("(?<=summer time we |\\G(?<!^), )\\w+");
for (Matcher m = regex.matcher(s); m.find(); )
    resultList.add(m.group());
String[] results = resultList.toArray(new String[resultList.size()]);
System.out.println(Arrays.toString(results));