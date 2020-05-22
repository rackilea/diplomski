for(Element elem : walkthroughs.select("div")) {
    for(Element inner : elem.children()) {
        String line = inner.ownText().trim();
        if(!line.equals(""))  //Skip empty lines
            outFile.println(line);
    }
}