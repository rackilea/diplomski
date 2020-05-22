private class Handler extends DefaultHandler{

    private StringBuilder temp_val;

    public Handler(){
        this.temp_val = new StringBuilder();
    }

    public void characters(char[] ch, int start, int length){
        temp_val.append(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName){
        System.out.println("Output: "+temp_val.toString());
        // ... Do your stuff
        temp_val.setLength(0); // Reset the StringBuilder
    }

}