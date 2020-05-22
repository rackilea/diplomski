bodyparts=new Vector();
  String body = "<br />testtestest<br />fefefefefefefefefef<br />qqqqqqqqqqqq";

  int previousIndex=0;
  while(body.indexOf("<br />",previousIndex)!=-1) {
    int index=body.indexOf("<br />",previousIndex);
    System.out.println(body.substring(previousIndex, index));
    bodyparts.addElement(body.substring(previousIndex, index));
    previousIndex=index+("<br />".size());
  }