Document doc = Jsoup.connect("example.com").get(); 
Iterator<Element> itr = doc.select("form").iterator()
while(itr.hasNext()){ 
   Element element = itr.next();
   System.out.println(element.html());
}