public static void test() {
   String text="<html>" +
   "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=us-ascii\" />" +
   "<title>Testing Escapes with DOM</title>" +
   "</head>" +
   "<body lang=\"en\"><p>This is an escape: &mdash;</p></body>" +
   "</html>";

   try {
       DocumentBuilder builder = 
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
       Document inputDoc = builder.parse(new ByteArrayInputStream(
                text.replace("&", "###").getBytes()));

       Transformer transformer = TransformerFactory.newInstance().newTransformer();
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       transformer.transform(new DOMSource(inputDoc), new StreamResult(baos));

       System.out.println("Result: " + baos.toString().replace("###", "&"));

       } catch (Exception ex) {
            ex.printStackTrace();
       }
 }