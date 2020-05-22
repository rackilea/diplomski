String test =""
        + "<div><img src=/slm/attachment/43647556403/My file with space.png /></div>"
        + "<div><img src=/slm/attachment/43647556403/My file with space.png name=whatever/></div>"
        + "<div><img src=/slm/attachment/43647556403/This  breaks  it.png name=whatever/></div>"
        + "<div><img src=\"/slm/attachment/43647556403/This  works.png\" name=whatever/></div>"
        + "<div><img src=/slm/attachment/43648152373/my_file_without_space.png/></div>";
Document doc = Jsoup.parse(test);
Elements imgs = doc.select("img");
for (Element img : imgs){
    Attribute src = null;
    StringBuffer newSrcVal = new StringBuffer();
    List<String> toRemove = new ArrayList<>();
    for (Attribute a : img.attributes()){
        if (a.getKey().equals("src")){
            newSrcVal.append(a.getValue());
            src = a;
        }
        else if (newSrcVal.length()>0){
            //we already found the scr tag
            if (a.getValue().isEmpty()){
                newSrcVal.append(" ").append(a.getKey());
                toRemove.add(a.getKey());
            }
            else{
                //the empty attributes, i.e. file name parts are over
                break;
            }
        }               
    }
    for (String toRemAttr : toRemove){
        img.removeAttr(toRemAttr);
    }
    src.setValue(newSrcVal.toString());
}
System.out.println(doc);