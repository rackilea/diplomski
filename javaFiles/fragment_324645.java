public class SplitUsingDocx4j {

/**
 * @param args
 * @throws Docx4JException
 * @throws FileNotFoundException
 */
public static void main(String[] args) throws Docx4JException,
        FileNotFoundException {
    File dir = new File(PropertyUtils.getProperty("INPUT_DIR"));
    String[] files = dir.list();
    File file = null;
    if (files.length == 0) {
        System.out.println("The directory is empty");
    } else {
        for (String aFile : files) {
            System.out.println(aFile);

            file = new File(PropertyUtils.getProperty("INPUT_DIR") + aFile
                    + "/" + aFile + ".docx");
        }
    }

    // Creating new documents
    WordprocessingMLPackage doc1 = WordprocessingMLPackage.createPackage();
    WordprocessingMLPackage doc2 = WordprocessingMLPackage.createPackage();

    // loading existing document
    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
            .load(new java.io.File(file.getPath()));
    MainDocumentPart tempDocPart = wordMLPackage.getMainDocumentPart();
    List<Object> obj = wordMLPackage.getMainDocumentPart().getContent();

    // for copying styles from existing doc to new docs
    StyleDefinitionsPart sdp = tempDocPart.getStyleDefinitionsPart();
    Styles tempStyle = sdp.getJaxbElement();
    doc1.getMainDocumentPart().getStyleDefinitionsPart()
            .setJaxbElement(tempStyle);
    doc2.getMainDocumentPart().getStyleDefinitionsPart()
            .setJaxbElement(tempStyle);

    boolean flag = false;
    for (Object object : obj) {
        if (!flag) {
            if (object.toString().equalsIgnoreCase("CONSTRUCTION DETAILS:")) {
                flag = true;
            }
            doc1.getMainDocumentPart().addObject(object);
        } else {
            doc2.getMainDocumentPart().addObject(object);
        }

    }
    String fileName = file.getName().toString().replace(".docx", "");
    doc1.save(new File(fileName + "-1.docx"));
    doc2.save(new File(fileName + "-2.docx"));
}}