final Pattern regex = Pattern.compile("<MAP>((.*):(.*),(.*))</MAP>", Pattern.DOTALL); 
final Matcher matcher = regex.matcher(whatyouwanttoparselatlongwiththeaboveformat); 
if (matcher.find()) { 
     System.out.print(matcher.group(2) + " : (lat,lon) = ");
     float latitude = Float.valueOf(matcher.group(3));
     float longitude = Float.valueOf(matcher.group(4));
     System.out.println(latitude + "," + longitude);
}