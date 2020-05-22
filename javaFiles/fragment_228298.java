public static String[][] convertTableHtmlTagsTo2DArray(String tableHtmlTags){

    String[] allRows=tableHtmlTags.split("</tr>");

    if(allRows!=null && allRows.length>0){
        int noOfRow=allRows.length;
        String[] allElementsInFirstRow=allRows[0].split("</td>");
        int noOfCol=allElementsInFirstRow.length;
        String[][] tableHtmlTagsIn2DArray=new String[noOfRow][noOfCol];

        for(int r=0; r<allRows.length; r++){
            String eachRow = allRows[r];
            String[] allElementsInEachRow=allRows[r].split("</td>");
            for(int e=0; e<allElementsInEachRow.length; e++){
                String eachElement=allElementsInEachRow[e];

                eachElement=MyValidation.cleanString(eachElement); // if it is null it will turn to "";

                eachElement=eachElement.replaceAll(".*<td>", "");
                eachElement=MyValidation.cleanString(eachElement);
                tableHtmlTagsIn2DArray[r][e]=eachElement;
            }
        }
        return tableHtmlTagsIn2DArray;
    }
    return null;
}