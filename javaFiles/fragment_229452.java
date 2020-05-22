int startIndex = content.indexOf(search);
if(startIndex > -1) {
    int endIndex = content.substring(startIndex).indexOf(".");
    if(endIndex > -1) {
        endIndex += startIndex;
        String foundString = content.substring(startIndex, endIndex);
        System.out.print(foundString);
    }
}