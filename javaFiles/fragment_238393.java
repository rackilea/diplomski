// let's find the iframe
 Document document = Jsoup.parse(inputstream, "iso-8859-1", url);
 Elements elements = document.select("iframe");
 Element iframe = elements.first();

 // now load the iframe
 URL iframeUrl = new URL(iframe.absUrl("src"));
 document = Jsoup.parse(iframeUrl, 15000);

 // extract the div
 Element div = document.getElementById("number_forecast");