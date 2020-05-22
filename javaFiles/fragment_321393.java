String data ="12345";
String sampleStr ="";
for(int i=0; i<10; i++) 
{
 data+=i;
 sampleStr += "<a href=\"javascript:yyy_getDetail(\'"+data+"\')\">"+data+"</a>"+", ";
} 

Pattern pattern = Pattern.compile("<a[^>]*>(.*?)</a>");
Matcher matcher = pattern.matcher(sampleStr );
while (matcher.find()) 
{
        System.out.println("Result "+ matcher.group(1));
}