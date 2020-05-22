String str = "[video url=\"http://www.example.com/path/to/my/video.ext\"]";
    if (str.contains("url=\""))
    {
        int indexoff = str.indexOf("url=\"");
        int indexofff = str.indexOf("\"]");
        String strurl = str.substring(indexoff, indexofff - indexoff);
        strurl = strurl.Replace("url=\"", ""); //get url string here

    }