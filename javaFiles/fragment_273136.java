Pattern p = Pattern.compile("(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))");
Matcher m = p.matcher(URLget);
StringBuffer sb = new StringBuffer();  
while (m.find())  
     {  
        URLget=m.group(1);  
        String URL="http://www.aman207.tk/yourls-api.php?signature=0a88314b95&action=shorturl&url="+ URLget;
        if (URLget.startsWith("http://")||URLget.startsWith("www."))
    {
        try {               
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(new URL(URL).openStream()));

            NodeList nodeList = doc.getElementsByTagName("shorturl");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node nNode = nodeList.item(temp);
                Element eElement = (Element) nNode;
                if(eElement.getAttribute("shorturl") != null)
                {
                    URLget=eElement.getTextContent();

                }
                else
                {

                }

            }

    }

       catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error occured");
    }  catch (SAXException e) {
        System.err.println("You either entered in an invalid URL, or our URL shortener services are down. Please try again.");
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    }
    }
    else
    {

    }
    m.appendReplacement(sb, "");
    sb.append(URLget);

     }
    m.appendTail(sb);
    return (sb.toString());