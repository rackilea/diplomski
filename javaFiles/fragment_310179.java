public class PDPageUtils {
    public static void main(String[] args) throws InvalidPasswordException, IOException {
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");

        PDDocument document = null;
        try {
            String filename = "src/main/resources/pdf/us-017.pdf";
            document = PDDocument.load(new File(filename));

            System.out.println("listIterator(PDPage)");
            ListIterator<PDPage> pageIterator = listIterator(document.getPage(0));
            while (pageIterator.hasNext()) {
                PDPage page = pageIterator.next();
                System.out.println("page #: " + pageIterator.nextIndex() + ", Structural Parent Key: " + page.getStructParents());
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    /**
     * Returns a <code>ListIterator</code> initialized with the list of pages from
     * the dictionary embedded in the specified <code>PDPage</code>. The current
     * position of this <code>ListIterator</code> is set to the position of the
     * specified <code>PDPage</code>.
     * 
     * @param page the specified <code>PDPage</code>
     * 
     * @see {@link java.util.ListIterator}
     * @see {@link org.apache.pdfbox.pdmodel.PDPage}
     */
    public static ListIterator<PDPage> listIterator(PDPage page) {
        List<PDPage> pages = new LinkedList<PDPage>();

        COSDictionary pageDictionary = page.getCOSObject();
        COSDictionary parentDictionary = pageDictionary.getCOSDictionary(COSName.PARENT);
        COSArray kidsArray = parentDictionary.getCOSArray(COSName.KIDS);

        List<? extends COSBase> kidList = kidsArray.toList();
        for (COSBase kid : kidList) {
            if (kid instanceof COSObject) {
                COSObject kidObject = (COSObject) kid;
                COSBase type = kidObject.getDictionaryObject(COSName.TYPE);
                if (type == COSName.PAGE) {
                    COSBase kidPageBase = kidObject.getObject();
                    if (kidPageBase instanceof COSDictionary) {
                        COSDictionary kidPageDictionary = (COSDictionary) kidPageBase;
                        pages.add(new PDPage(kidPageDictionary));
                    }
                }
            }
        }
        int index = pages.indexOf(page);
        return pages.listIterator(index);
    }
}