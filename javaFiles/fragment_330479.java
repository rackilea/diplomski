public static void replaceLinksInPdf(String filePath) {
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(filePath));
            // Decrypt a document
            if (document.isEncrypted()) {
                document.setAllSecurityToBeRemoved(true);
                System.out.println(filePath + " Doc was decrypted");
            }

            // replace all links in a footer and a header in XObjects with /ProcSet [/PDF /Text]
            // Note: these forms (and pattern objects too!) can have resources,
            // i.e. have Form XObjects or patterns again.
            // If so you need to use a recursion
            for (int pageNum = 0; pageNum < document.getPages().getCount(); pageNum++) {
                List<Object> newPdxTokens = new ArrayList<Object>();
                // Get all XObjects from the page
                Iterable<COSName> xobjs = document.getPage(pageNum).getResources().getXObjectNames();
                for (COSName xobj : xobjs) {
                    boolean isHasTextStream = false;
                    PDXObject pdxObject = document.getPage(pageNum).getResources().getXObject(xobj);
                    // If a stream has not '/ProcSet [/PDF /Text]' line inside it has to be skipped
                    // isXobjectHasTextFieldInPdf has a recursion
                    if (pdxObject.getCOSObject() instanceof COSDictionary) {
                        isHasTextStream = isXobjectHasTextFieldInPdf((COSDictionary) pdxObject.getCOSObject());
                    }

                    if (pdxObject instanceof PDFormXObject && isHasTextStream) {
                        // Set stream from pdxObject
                        PDStream stream = pdxObject.getStream();
                        PDFStreamParser streamParser = new PDFStreamParser(stream.toByteArray());
                        streamParser.parse();
                        for (Object token : streamParser.getTokens()) {
                            if (token instanceof Operator) {
                                Operator op = (Operator) token;
                                if (op.getName().equals("Tj")) {
                                    // Tj contains 1 COSString
                                    COSString previous = (COSString) newPdxTokens.get(newPdxTokens.size() - 1);
                                    String string = previous.getString();
                                    // here can be any filters for checking a necessary string
                                    if (string.equals("www.testlink.com")) {
                                        COSArray newLink = new COSArray();
                                        newLink.add(new COSString("test.test.com"));
                                        newPdxTokens.set(newPdxTokens.size() - 1, newLink);
                                    }
                                } else if (op.getName().equals("TJ")) {
                                    // TJ contains a COSArray with COSStrings and COSFloat (padding)
                                    COSArray previous = (COSArray) newPdxTokens.get(newPdxTokens.size() - 1);
                                    String string = "";
                                    for (int k = 0; k < previous.size(); k++) {
                                        Object arrElement = previous.getObject(k);
                                        if (arrElement instanceof COSString) {
                                            COSString cosString = (COSString) arrElement;
                                            String content = cosString.getString();
                                            string += content;
                                        }
                                    }
                                    // here can be any filters for checking a necessary string
                                    // check if string contains a necessary link
                                    if (string.equals("www.testlink.com")) {
                                        COSArray newLink = new COSArray();
                                        newLink.add(new COSString("test.test.com"));
                                        newPdxTokens.set(newPdxTokens.size() - 1, newLink);
                                    } else if (string.startsWith("www.testlink.com")) {
                                        // this code should be changed. It can have some indenting problems that depend on COSFloat values
                                        COSArray newLink = (COSArray) newPdxTokens.get(newPdxTokens.size() - 1);
                                        int size = newLink.size();
                                        float f = ((COSFloat) newLink.get(size - 4)).floatValue();
                                        for (int i = 0; i < size - 4; i++) {
                                            newLink.remove(0);
                                        }
                                        newLink.set(0, new COSString("test.test.com"));
                                        // number for indenting from right place. Should be checked.
                                        newLink.set(1, new COSFloat(f - 8000));
                                        newPdxTokens.set(newPdxTokens.size() - 1, newLink);
                                    }
                                }
                            }
                            // save tokens to a temporary List
                            newPdxTokens.add(token);
                        }
                        // save the replaced data back to the srteam
                        OutputStream out = stream.createOutputStream();
                        ContentStreamWriter writer = new ContentStreamWriter(out);
                        writer.writeTokens(newPdxTokens);
                        out.close();
                    }
                }
            }

            // replace data from any text stream from pdf. XObjects not included.
            int pageNum = 0;
            for (PDPage page : document.getPages()) {
                PDFStreamParser parser = new PDFStreamParser(page);
                parser.parse();
                // Get all tokens from the page
                List<Object> tokens = parser.getTokens();
                // Create a temporary List
                List<Object> newTokens = new ArrayList<Object>();

                for (Object token : tokens) {
                    if (token instanceof Operator) {
                        COSDictionary dictionary = ((Operator) token).getImageParameters();
                        if (dictionary != null) {
                            System.out.println(dictionary.toString());
                        }
                    }
                    if (token instanceof Operator) {
                        Operator op = (Operator) token;
                        if (op.getName().equals("Tj")) {
                            // Tj contains 1 COSString
                            COSString previous = (COSString) newTokens.get(newTokens.size() - 1);
                            String string = previous.getString();
                            // here can be any filters for checking a necessary string
                            if (string.equals("www.testlink.com")) {
                                COSArray newLink = new COSArray();
                                newLink.add(new COSString("test2.test2.com"));
                                newTokens.set(newTokens.size() - 1, newLink);
                            }
                        } else if (op.getName().equals("TJ")) {
                            // TJ contains a COSArray with COSStrings and COSFloat (padding)
                            COSArray previous = (COSArray) newTokens.get(newTokens.size() - 1);
                            String string = "";
                            for (int k = 0; k < previous.size(); k++) {
                                Object arrElement = previous.getObject(k);
                                if (arrElement instanceof COSString) {
                                    COSString cosString = (COSString) arrElement;
                                    String content = cosString.getString();
                                    string += content;
                                }
                            }
                            // here can be any filters for checking a necessary string
                            if (string.equals("www.testlink.com")) {
                                COSArray newLink = new COSArray();
                                newLink.add(new COSString("test.test.com"));
                                newTokens.set(newTokens.size() - 1, newLink);
                            } else if (string.startsWith("www.testlink.com")) {
                                // this code should be changed. It can have some indenting problems that depend on COSFloat values
                                COSArray newLink = (COSArray) newTokens.get(newTokens.size() - 1);
                                int size = newLink.size();
                                float f = ((COSFloat) newLink.get(size - 4)).floatValue();
                                for (int i = 0; i < size - 4; i++) {
                                    newLink.remove(0);
                                }
                                newLink.set(0, new COSString("test.test.com"));
                                // number for padding from right place. Should be checked.
                                newLink.set(1, new COSFloat(f - 8000));
                                newTokens.set(newTokens.size() - 1, newLink);
                            }
                        }
                    }
                    // save tokens to a temporary List
                    newTokens.add(token);
                }
                // save the replaced data back to the document's srteam
                PDStream newContents = new PDStream(document);
                OutputStream out = newContents.createOutputStream(COSName.FLATE_DECODE);
                ContentStreamWriter writer = new ContentStreamWriter(out);
                writer.writeTokens(newTokens);
                out.close();

                // save content
                page.setContents(newContents);

                // replace all links that have a pop-up line (It does not affect the visible text)
                pageNum++;
                List<PDAnnotation> annotations = page.getAnnotations();
                for (PDAnnotation annotation : annotations) {
                    PDAnnotation annot = annotation;
                    if (annot instanceof PDAnnotationLink) {
                        PDAnnotationLink link = (PDAnnotationLink) annot;
                        PDAction action = link.getAction();
                        if (action instanceof PDActionURI) {
                            PDActionURI uri = (PDActionURI) action;
                            String newURI = "www.test1.test1.com";
                            uri.setURI(newURI);
                        }
                    }
                }
            }

            // save document
            document.save(filePath.replace("file", "file_result"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }