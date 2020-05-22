if(!list.isEmpty()){
    List<Object> listObjNode;
    for(int i = 0; i < list.size(); ++i){
        List<Object> r = ((R)list.get(i)).getContent();
        for(int j = 0; j < r.size(); ++j){
            javax.xml.bind.JAXBElement jaxb = (javax.xml.bind.JAXBElement)r.get(j);
            org.docx4j.wml.Text t = (org.docx4j.wml.Text)jaxb.getValue();
            System.out.println(t);
        }
    }
}