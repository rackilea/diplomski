double sum = 0.0;
for (int temp = 0; temp < nList.getLength(); temp++) 
    {
    Node nNode = nList.item(temp);

    if (nNode.getNodeType() == Node.ELEMENT_NODE) 
            { 
        Element eElement = (Element) nNode;

        sum += Double.parseDouble(eElement.getElementsByTagName("duration").item(0).getTextContent());
            }
    }
System.out.println("Total: " + sum);