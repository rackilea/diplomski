// load page using HTML Unit and fire scripts
WebClient webClient = new WebClient();
HtmlPage myPage = webClient.getPage(myURL);

// convert page to generated HTML and convert to document
doc = Jsoup.parse(myPage.asXml());

// do something with html content
System.out.println(doc.html());

// clean up resources        
webClient.close();