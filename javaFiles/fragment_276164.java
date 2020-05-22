Document doc =Jsoup.connect("http://stackoverflow.com/questions/16780517/java-obtain-text-within-script-tag-using-jsoup").timeout(10000).get();
 Elements scriptElements = doc.getElementsByTag("script");

 for (Element element :scriptElements ){                
        for (DataNode node : element.dataNodes()) {
            System.out.println(node.getWholeData());
        }
        System.out.println("-------------------");            
  }