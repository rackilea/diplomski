String line;
Substance actualSubstance = null;
while((line = br.readLine()) != null) {
    String[] columns = line.split("\t");
    if (columns[0].equals("S")) {
        actualSubstance = new Substance();
        // parse main substance
    } else if (columns[0].equals("SS")) {
        if(actualSubstance != null) {
            Synonym synonym = new Synonym(); 
            // parse synonim substance and add to actual main substance
            actualSubstance.addSynonym(synonym);
        } else {
            // bad format of the input file -> handle accordingly 
        }
    } else {
        // junk
    }
}