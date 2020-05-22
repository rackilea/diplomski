Elements es = doc.select("div");
for(int i=0; i < es.size(); i++){
  if(es.get(i).attr("style").equals("A"))
     es.get(i).addClass("class01").removeAttr("style");

  //similarly for other cases
}