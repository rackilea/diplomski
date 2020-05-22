public String handleTag(String buf, String[] attrList) {
    StringBuilder temp = new StringBuilder();
    final String[] prefix = {"BLOPABP","\nBLOPCALL","\nBLOPEXP",
                       "\nBLOPHEAD","\nBLOPMAJ"};
    for(int i=0;i<attrList.length;i++){
        String startPattern = START+attrList[i]+">";
        String endPattern = END+attrList[i]+">";
        String extract = new String(buf);
        extract = extract.substring(
                extract.indexOf(startPattern)+startPattern.length(), 
                extract.indexOf(endPattern));
        temp.append(prefix[i%5]+extract);
    }

  return temp.toString();
}