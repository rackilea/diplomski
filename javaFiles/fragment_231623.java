private final static RenderListener nopListener = new RenderListener() {
        @Override
        public void renderText(TextRenderInfo renderInfo) { }

        @Override
        public void renderImage(ImageRenderInfo renderInfo) { }

        @Override
        public void endTextBlock() { }

        @Override
        public void beginTextBlock() { }
    };

static class Do implements ContentOperator {
        public void invoke(PdfContentStreamProcessor processor, PdfLiteral operator, ArrayList<PdfObject> operands) {
            PdfName xobjectName = (PdfName)operands.get(0);
            names.add(xobjectName);
        }

        final List<PdfName> names = new ArrayList<>();
    }

private static void fixPdfReader(PdfReader reader) throws IOException {
        PdfContentStreamProcessor processor = new PdfContentStreamProcessor(nopListener);
        Do doOp = new Do();
        processor.registerContentOperator("Do", doOp);
        int totPages = reader.getNumberOfPages();
        for (int page = 1; page <= totPages; page++) {
            PdfDictionary resources = reader.getPageResources(page);
            if (resources == null) {
                System.out.printf("!!! page %d has no resources\n", page);
                continue;
            }
            doOp.names.clear();
            processor.processContent(ContentByteUtils.getContentBytesForPage(reader, page), resources);
            PdfDictionary newResources = new PdfDictionary();
            newResources.putAll(resources);
            PdfDictionary xobjects = newResources.getAsDict(PdfName.XOBJECT);
            PdfDictionary newXobjects = new PdfDictionary();
            for (PdfName key: doOp.names) {
                newXobjects.put(key, xobjects.get(key));
            }
            newResources.put(PdfName.XOBJECT, newXobjects);
            reader.getPageN(page).put(PdfName.RESOURCES, newResources);
        }
        reader.removeUnusedObjects();
    }

public static String fixAndSplitPDF(InputStream inputStream, String targetDir) {
        try {
            PdfReader reader = new PdfReader(inputStream);
            fixPdfReader(reader);
            //this method is in the question!
            return splitAndRenamePdf(reader, targetDir);
        } catch (IOException exc) {
            //LOG Exception...
            return null;
        }
    }