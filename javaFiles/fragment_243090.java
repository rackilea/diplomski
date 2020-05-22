Pattern pattern = Pattern.compile("\\w+?\\d+"); //compiles the pattern we want to use
Matcher matcher = pattern.matcher("xyz213123kop234430099kpf4532"); //we create the matcher on certain string using our pattern

while(matcher.find()) //while the matcher can find the next match
{
    System.out.println(matcher.group()); //print it
}