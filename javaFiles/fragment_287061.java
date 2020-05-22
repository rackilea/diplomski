{
  private static String[] urllinks;
  private static ArrayList<String> mStringList = new ArrayList<>();
  ...

  int i = 0;
  for (Element el : links) {
       String url = el.attr("abs:href");
       if (url != null) {
                mStringList.add(i, url);
                i++;
            } 
       else {
          // Do something
       }

  urllinks = mStringList.toArray(urllinks);
  // check if urls are actualy in string array
  Log.d("LINK 1", urllinks[0]);
  Log.d("LINK 2", urllinks[1]);
...
}