String text = "Pubblichiamo la presentazione di IBM riguardante DB2 per i vari sistemi operativi"
    +"Linux, UNIX e Windows.\r\n\r\nQuesto documento sta sulla piattaforma KM e lo potete"
    +"scaricare a questo <a href=\'https://sfkm.griffon.local/sites/BSF%20KM/BSF/CC%20T/Specifiche/Eventi2008/IBM%20DB2%20for%20Linux,%20UNIX%20e%20Windows.pdf\' target=blank>link</a>.";

TextExtractor te = new TextExtractor(new Source(text)){
    @Override
    public boolean excludeElement(StartTag startTag) {
        return startTag.getName() != HTMLElementName.A;
    }
};
System.out.println(te.toString());