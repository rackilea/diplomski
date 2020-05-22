public Document build(Crypto cr) throws WSSecurityException {
        LOG.debug("Beginning signing...");
        this.prepare(cr);
        if (this.getParts().isEmpty()) {
            this.getParts().add(WSSecurityUtil.getDefaultEncryptionPart(this.getDocument()));

            // --- Here is my edit - And it works!

            WSEncryptionPart aaa = new WSEncryptionPart("something","somethingNamespace","");
            this.getParts().add(aaa);

            // ----------------------------------

        } else {
            Iterator var2 = this.getParts().iterator();

            label33:
            while(true) {
                while(true) {
                    if (!var2.hasNext()) {
                        break label33;
                    }

                    WSEncryptionPart part = (WSEncryptionPart)var2.next();
                    if (part.getId() == null && "STRTransform".equals(part.getName())) {
                        part.setId(this.strUri);
                    } else if ("KeyInfo".equals(part.getName()) && "http://www.w3.org/2000/09/xmldsig#".equals(part.getNamespace()) && part.getElement() == null) {
                        Element keyInfoElement = this.getKeyInfoElement();
                        part.setElement(keyInfoElement);
                    }
                }
            }
        }

        List<javax.xml.crypto.dsig.Reference> referenceList = this.addReferencesToSign(this.getParts());
        this.computeSignature(referenceList);
        if (this.bstToken != null) {
            this.prependBSTElementToHeader();
        }

        return this.getDocument();
    }