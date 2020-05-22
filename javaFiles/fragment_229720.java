for (int temp = 0; temp < NodeOzet.getLength(); temp++){
        Node nOzet = NodeOzet.item(temp);
        NodeList carList = eElement.getElementsByTagName("cars")
        String cars = "";
        for(int temp2 = 0; temp2 < carList.getLength(); temp2++){
             cars += ((Element)carList.item(temp2)).getAttribute("carname") + "\t";
        }
     }