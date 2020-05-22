TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();


            //CREAR STRING DEL ARBOL XML
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();
            System.out.println(xmlString);

            dbfac = DocumentBuilderFactory.newInstance();
            dbfac.setNamespaceAware(true);
            doc = dbfac.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));