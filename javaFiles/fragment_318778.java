PDDocument documentoPdf = 
        PDDocument.loadNonSeq(new File("docs_compuestos/50.pdf"), new RandomAccessFile(new File("./tmp/t"), "rw"));

        int numPages = documentoPdf.getNumberOfPages();
        List pages = documentoPdf.getDocumentCatalog().getAllPages();


        int previusQR = 0;
        for(int i =0; i<numPages; i++){
            PDPage firstPage = (PDPage) pages.get(i);
            String qrText ="";


            BufferedImage firstPageImage = firstPage.convertToImage(BufferedImage.TYPE_USHORT_565_RGB , 200);


            firstPage =null;

            try {
                qrText = readQRWithQRCodeMultiReader(firstPageImage, hintMap);
            } catch (NotFoundException e) {
                e.printStackTrace();
            } finally {
                firstPageImage = null;
            }


        if(i != 0 && qrText!=null){
                    PDDocument outputDocument = new PDDocument();
                    outputDocument.setDocumentInformation(documentoPdf.getDocumentInformation());
                    outputDocument.getDocumentCatalog().setViewerPreferences(
                            documentoPdf.getDocumentCatalog().getViewerPreferences());


                    for(int j = previusQR; j<i; j++){
                        PDPage importedPage = outputDocument.importPage((PDPage)pages.get(j));

                        importedPage.setCropBox( ((PDPage)pages.get(j)).findCropBox() );
                        importedPage.setMediaBox( ((PDPage)pages.get(j)).findMediaBox() );
                        // only the resources of the page will be copied
                        importedPage.setResources( ((PDPage)pages.get(j)).getResources() );
                        importedPage.setRotation( ((PDPage)pages.get(j)).findRotation() );

                        processAnnotations(importedPage);


                    }


                    File f = new File("./splitting_files/"+previusQR+".pdf");

                    previusQR = i;

                    outputDocument.save(f);
                    outputDocument.close();
                }
            }


        }