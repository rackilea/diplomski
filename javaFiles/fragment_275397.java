public static void main(String[] args) throws FileNotFoundException, IOException {
    String xml = null;
    try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Desktop\\TestXML.xml")))  {
        String readLine =null;
        while((readLine = reader.readLine()) != null)  {
            xml += readLine; 
        }
    }
    JSONObject jsonObject = XML.toJSONObject(xml);
    System.out.println(jsonObject.toString(1));
}