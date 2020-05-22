XPathExpression CardAcctTpexpr = xpath.compile("//Ntfctn/Ntry/NtryDtls/TxDtls/SplmtryData/Envlp/Cnts/CardAcctTp");
            Object CardAcctTp = CardAcctTpexpr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodesCardAcctTp = (NodeList) CardAcctTp;
            for(int i = 0; i < nodesCardAcctTp.getLength(); i++){
                Element CardAcctTpel = (Element) nodesCardAcctTp.item(i);
                CardAcctTpS = Utilities.xmlToString(CardAcctTpel);
                int length = CardAcctTpS.length();
                CardAcctTpS = CardAcctTpS.substring(50,length);
                length = CardAcctTpS.length();
                CardAcctTpS = CardAcctTpS.substring(0,length-13);
                CardAcctTpAL.add(CardAcctTpS);

            }