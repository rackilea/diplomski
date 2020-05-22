Document doc = Jsoup.connect("http://www.davidsassoonlibrary.com/index.php?action=book_details")
  .data("search", "search")
  .data("title", "Test Cricket Lists")
  //fields which are being passed in post request.
  .userAgent("Mozilla")
  .post();
   System.out.println(doc); // will print html source