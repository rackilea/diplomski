int startIndex = content.indexOf(search);
if(startIndex > -1) {
    int endIndex = content.indexOf('.', startIndex);
    if(endIndex > -1) {
        String foundString = content.substring(startIndex, endIndex);
        System.out.print(foundString);
    }
}