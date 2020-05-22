//doc1.save("C:\\Users\\user\\Desktop\\working.pdf");

                    StandardSecurityHandler sh = new StandardSecurityHandler(spp);
                    sh.prepareDocumentForEncryption(doc1);

                    hash = new String(doc1.getEncryption().getOwnerKey());