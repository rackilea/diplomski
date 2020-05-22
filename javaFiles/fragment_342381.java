public class Main {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
        ConsoleMenuEntry rootEntry = ((JAXBElement<ConsoleMenuEntry>) jc.createUnmarshaller().unmarshal(new File("PATH_TO_FILE\\test.xml"))).getValue();
        processMenuEntry(rootEntry);
    }

    private static void processMenuEntry(ConsoleMenuEntry menuEntry) {
        System.out.println("Index (attr) = " + menuEntry.getIndex() + ", Text (attr) = '" + menuEntry.getText() + "'");

        for (Serializable element : menuEntry.getContent()) {
            if (element instanceof JAXBElement) {
                processMenuEntry(((JAXBElement<ConsoleMenuEntry>) element).getValue());
            } else if (element instanceof String) {
                String innerText = element.toString().trim();
                if (innerText.length() > 0) {
                    System.out.println("Inner text: '" + innerText);
                }
            }
        }
    }
}