Document doc = Jsoup.connect("http://www.mySite.com/post.php")
   .data("titolo", titolo)
   .data("prezzo", price)
   .data("comune", comune)
   .data("descrizione", descrizione)
   .data("link[]", "http://example1.com")
   .data("link[]", "http://example2.com")
   .data("link[]", "http://example3.com")
   .post();
System.out.println(doc.text());