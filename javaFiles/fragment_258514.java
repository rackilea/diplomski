//[...]
 Map<String, TextField> map; //Global variable
 //I just have to add the new TextFields to the HashMap
 private void mapSaveRangs() {
    map = new HashMap<>();
    map.put("rangInitial1", tfrangInitial1);
    map.put("rangFinal1", tfrangFinal1);
    map.put("rangInitial2", tfrangInitial2);
    map.put("rangFinal2", tfrangFinal2);
    map.put("rangInitial3", tfrangInitial3);
    map.put("rangFinal3", tfrangFinal3);
    map.put("rangInitial4", tfrangInitial4);
    map.put("rangFinal4", tfrangFinal4);
    map.put("rangInitial5", tfrangInitial5);
    map.put("rangFinal5", tfrangFinal5);
}

private void rangsInPairsXML(Element peeRangs) {
    String sKeyrInitial = "rangInitial";
    String sValuerInitial;
    String sKeyrFinal = "rangFinal";
    String sValuerFinal;
    //Making sure that we have pair of 2 
    if (map.size() % 2 == 0) {
        //map half size loop
        for (int numRang = 1; numRang <= map.size() / 2; numRang++) {
            sValuerInitial = map.get(sKeyrInitial + numRang).getText();
            sValuerFinal = map.get(sKeyrFinal + numRang).getText();

            //Verifying values and saving it in peeRang (XML Element)
            if (!(sValuerInitial.equals("") || sValuerFinal.equals(""))) {
                Element eRang = new Element("RANG");
                eRang.addContent(new Element("INITIAL").addContent(sValuerInitial));
                eRang.addContent(new Element("FINAL").addContent(sValuerFinal));
                peeRangs.addContent(eRang);
            }
        }
    } else {
        System.out.println("ERROR!!");
        //[...]
    }
}