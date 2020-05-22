Elements tables = doc.select("table");
Element table = null;

for(Element tableElement : tables){
    if(tableElement.hasClass("W(100%)")){
        table = tableElement;
    }
}