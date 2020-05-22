public boolean ReadXmlFile(String filePath)
    {
        try {
            String Data="";
            File fIN = new File(filePath);

            if (fIN.exists()) 
            {
                StringBuffer fileData = new StringBuffer(1000);
                BufferedReader reader = new BufferedReader(
                        new FileReader(filePath));
                char[] buf = new char[1024];
                int numRead=0;

                while((numRead=reader.read(buf)) != -1){            
                    String readData = String.valueOf(buf, 0, numRead);
                    fileData.append(readData);              
                    buf = new char[1024];
                }

                reader.close();   
                Data= fileData.toString();

            }
            else
            {

                return false;
            }

            docData = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            try 
            {           
                DocumentBuilder db = dbf.newDocumentBuilder();          
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(Data));
                docData = db.parse(is);         
            } catch (ParserConfigurationException e) {          
                return false;
            } catch (SAXException e) {          
                return false;
            } catch (IOException e) {           
                return false;
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }