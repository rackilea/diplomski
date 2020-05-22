Document doc = Jsoup.connect("http://your/url/here").get(); // or Jsoup.parse(htmlString);
Elements header = doc.select("#header"); //access to <div id="header">...</div>
    Elements inputs = header.select("input");
    for(Element input : inputs){
        System.out.println(input); //print <input>....</input>
        System.out.println(input.attr("id")); //printing attribute id
    }