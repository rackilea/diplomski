import java.io.File;
    import java.util.List;

    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;

    import org.w3c.dom.Document;
    import org.w3c.dom.NodeList;

    public class ReadFiles {
        public static void main(String[] args) {

            File dir = new File("D:/Work"); //Directory where your file exists

            File [] files = dir.listFiles();

            for(File file : files) {
                if(file.isFile() && file.getName().endsWith(".xml")) { //You can validate file name with extension if needed
                    ProcessFile(file, Entities);  // Assumed you have declared Entities, may be list of other collection
                }
            }

            System.out.println(Entities);
        }

        private static void ProcessFile(File fXmlFile, List<E> Entities) {
            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("sindex");

                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    System.out.println("");

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                        System.out.println("Count : " + eElement.getElementsByTagName("count").item(0).getTextContent());

                        Entity CE = new Entity(eElement.getElementsByTagName("name").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("count").item(0).getTextContent()));
                        Entities.add(CE);
                        System.out.println("Entity added! ");
                    }
                }           
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }