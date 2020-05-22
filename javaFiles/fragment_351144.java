String[] mycountries= new String[countries.length];
String[] myotherstuff = new String[countries.length];
 for(int i = 0; i < countries.length; i++) {
    String s = countries[i];
    String[] parts = s.split(","); 
    myotherstuff[i] = parts[0]+","+parts[1];
    mycountries[i] = parts[2];
}