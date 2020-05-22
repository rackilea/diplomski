Elements bTags = htmlDocument.select("div.column.two-third > div b");

if(bTags.size()>8){
    Element title = bTags.get(8);
    String text = title.parent().childNode(title.siblingIndex()+1).toString();
    System.out.println(title.text() + "\n" + text);
}