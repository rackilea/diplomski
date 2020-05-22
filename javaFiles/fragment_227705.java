XPathExpression RfrdDocInfNbexpr = xpath.compile("//Ntfctn/Ntry/NtryDtls/TxDtls/RmtInf/Strd/RfrdDocInf/Nb");
            Object RfrdDocInfNb = RfrdDocInfNbexpr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodesRfrdDocInfNb = (NodeList) RfrdDocInfNb;
            for(int i = 0; i < nodesRfrdDocInfNb.getLength(); i++){
                Element RfrdDocInfNbel = (Element) nodesRfrdDocInfNb.item(i);
                RfrdDocInfNbS = Utilities.xmlToString(RfrdDocInfNbel);
                int length = RfrdDocInfNbS.length();
                RfrdDocInfNbS = RfrdDocInfNbS.substring(42,length);
                length = RfrdDocInfNbS.length();
                RfrdDocInfNbS = RfrdDocInfNbS.substring(0,length-5);
                RfrdDocInfNbAL.add(RfrdDocInfNbS);

            }