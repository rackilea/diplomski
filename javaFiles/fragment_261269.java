String result;
int start = responseStr.indexOf("<rss>");
int end = responseStr.lastIndexOf("</rss>");

if (start != -1 && end != -1)
{
  result = "rss string = " + responseStr.substring(start, end + 6);
}
else
{
  result = "rss string not found";
}

System.out.println(result);