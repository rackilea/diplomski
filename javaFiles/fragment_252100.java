String str = "Ram Is A Good Boy";
String [] strArray = str.split(" ");
StringBuilder sb = new StringBuilder();
for(int i=strArray.length-1;i>-1;i--)
{
    sb.append(strArray[i]+" ");
}
System.out.println(sb.toString());