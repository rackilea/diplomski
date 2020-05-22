public class JaxbTest {
        public static void main(String[] args) {

            String xml = "<System>\n" +
                    "   <ID>e5b160d0</ID>\n" +
                    "   <Source>\n" +
                    "     <Name>Kron</Name>\n" +
                    "   </Source>\n" +
                    "</System>";
            SystemDTO systemDTO;
            try {

                JAXBContext jaxbContext = JAXBContext.newInstance(SystemDTO.class);

                StringReader reader = new StringReader(xml);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                systemDTO = (SystemDTO) jaxbUnmarshaller.unmarshal(reader);
                System.out.println(systemDTO.getSource().getName());

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

    }