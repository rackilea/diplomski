List list = document.selectNodes("//resources/@id" ); //using xpath
Iterator iter=list.iterator();
while(iter.hasNext()){
    Attribute attribute=(Attribute)iter.next();
    jCombo.addItem(attribute.getValue());
}