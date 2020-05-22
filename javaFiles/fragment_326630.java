String htmlString = "<html><p><b>This has no div</b></p><div><div><div><p><b>This is first line</b></p></div><b>This is second line</b></div><div>This is output</div><div><span style=\"color:blue\">This is third line</span></div></html>";

Document doc = Jsoup.parse(htmlString);

Elements elements = doc.getAllElements();

// for all textnodes
outerloop:
for (Element element : elements) {
    if(element.childNodes().size()>0 && element.childNode(0).nodeName().equals("#text")){
        Element divContent = element;

        if(divContent.nodeName().equals("div")){
            System.out.println("No element in div; text: " + element.text()+ "\n");
        }else{  
            while(divContent.parents().size()>0 && !divContent.parent().nodeName().equals("div")){
                divContent = divContent.parent();
                if(divContent.parent().nodeName().equals("body")){
                    continue outerloop; // continue, to skip element <p><b>This has no div</b></p>
                    //break; // break, if you want the element <p><b>This has no div</b></p> anyway 
                }
            }

            System.out.println("element: " + divContent.toString());
            System.out.println("text: " + element.text() + "\n");
        }
    }
}

// only for <div>text...</div>
for (Element element : elements) {
    if(element.childNodes().size()>0 && element.childNode(0).nodeName().equals("#text") && element.nodeName().equals("div")){
        System.out.println("text: " + element.text());
    }
}