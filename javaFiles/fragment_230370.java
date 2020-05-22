List<String> yourList = new ArrayList<String>();
NodeList nl = e.getElementsByTagName ("no_of_comments");
if(nl != null){
    for(int i = 0;i<nl.getLength();i++) 
    {   
        Node n = nl.item(i).getFirstChild();
        if(n!=null){
             String value = n.getNodeValue();
             yourList.add(value);
        }
    }
}