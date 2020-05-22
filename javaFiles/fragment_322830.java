Pattern metaPattern = Pattern.compile("meta .*\"last-modified\" content="(.*)");
Matcher metaMatch = metaPattern.matcher(sampleString);
if metaMatch.matches()
{
    System.out.println(metaMatch.group(1));
}