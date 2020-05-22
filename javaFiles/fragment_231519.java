Document document = Jsoup.connect("http://forbesindia.com/celebload2015.php")
                    .data("page_no", "all")
                    .data("list_id", "1519")
                    .data("category", "All")
                    .data("order", "rank")
                    .data("name", "")
                    .post();

   Elements img = document.select("img");
   for (Element element : img) {
       System.out.println(element.attr("alt"));
       System.out.println(element.absUrl("src"));
   }