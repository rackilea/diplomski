public class Tclass {

    public static void main(String argv[]) {

        try {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        for(int x = 1; x < 3; x = x+1)
        {

           // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("product");
            doc.appendChild(rootElement);
            int a = 351;
            Random rand = new Random(); 
            int maximum = 5;
            int minimum = 2;
            int range = maximum - minimum + 1;

            // staff elements
            Element staff = doc.createElement("product_id");
            rootElement.appendChild(staff);

            // shorten way
            staff.setAttribute("value", ""+x);

            Element tab_id = doc.createElement("tab_id");
            staff.appendChild(tab_id);

            int randomNum =  rand.nextInt(range) + minimum;     
            // shorten way
            tab_id.setAttribute("value", ""+randomNum);



// write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("file"+x+".xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } 


        } catch (ParserConfigurationException pce) {
          pce.printStackTrace();
        } catch (TransformerException tfe) {
          tfe.printStackTrace();
        }
    }
}