//Assuming you won't ever change it, make it a final
//variable for less memory usage.
final String URL = "http://www.xbox.com/en-US/security";

//Whatever piece of processing here

//Some tests just to make sure you'll get what you're
//fetching:
String newUrl = ""
if (checkUrl.startsWith("/"))
    newUrl = URL + checkUrl;

if (checkUrl.startsWith("http://"))
    newUrl = checkUrl;

if (checkUrl.startsWith("www"))
    newUrl = "http://" + checkUrl;