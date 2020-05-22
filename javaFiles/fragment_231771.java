Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
Matcher m = pattern.matcher("1.5+4.2*(5+2)/10-4");
while(m.find()) {
    System.out.printf("%s ", m.group());
}

output: 1.5 + 4.2 * ( 5 + 2 ) / 10 - 4