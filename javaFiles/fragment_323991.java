for (int f = 0; f < fin.length; f++) //fin be string array of urls
{
    try {
        Document finaldoc = Jsoup.connect(fin[f]).get();
        out.println(finaldoc.title());
    }
    catch (SocketTimeoutException exception) {
        continue;
    }
}