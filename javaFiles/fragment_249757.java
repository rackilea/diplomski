Element signedProperties = qualifyingProperties.getOwnerDocument()
                .createElementNS("http://uri.etsi.org/01903/v1.3.2#",
                        "xades:SignedProperties");
        signedProperties.setAttributeNS("", "Id", "SignedProperties-"
                + SIGNATURE_ID);//Set ID attribute

        signedProperties.setIdAttributeNS("", "Id", true);//register attribute as id