public static void main(String[] args) throws JAXBException, FileNotFoundException {
    System.out.println("Output from our XML File: ");
    JAXBContext context = JAXBContext.newInstance(Details.class);
    Unmarshaller um = context.createUnmarshaller();
    Details details = (Details)um.unmarshal(new FileReader("details.xml"));
    List<String> detailA = details.getDetailA();
    List<String> detailB = details.getDetailB();

    Map<String, String[]> map = new HashMap<String, String[]>();
    map.put("detail-a", detailA.toArray(new String[detailA.size()]));
    map.put("detail-b", detailB.toArray(new String[detailB.size()]));


    for (Map.Entry<String, String[]> entry : map.entrySet()) {
        //key "detail a" value={"attribute 1 of detail a","attribute 2 of detail a","attribute 3 of detail a"}
        System.out.print("Key \"" +entry.getKey()+"\" value={");
        for(int i=0;i<entry.getValue().length;i++){
            if(i!=entry.getValue().length-1){
                System.out.print("\""+entry.getValue()[i]+"\",");
            }
            else{
                System.out.print("\""+entry.getValue()[i]+"\"}");
            }
        }
        System.out.println();
    }
}