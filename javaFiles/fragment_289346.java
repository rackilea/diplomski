Document doc; //comes as parameter

Elements divs = doc.getElementsByTag("div");
for(Element div: divs){
    if(div.getElementsByTag("div").size() == 1){
        //is a div with no divs inside it
    }
}