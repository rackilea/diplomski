public static void main(String[] args) {
      String temp = null;
      String searchedData = null;
      File file = new File(fileLocation);
      try{
            Scanner scan = new Scanner (file);
            scan.useDelimiter("xml version");
            while (scan.hasNext()){
                  temp = scan.next();
                  if(temp.contains("<ns1:EventCorrelationID>153721264</ns1:EventCorrelationID>")){
                        searchedData = temp.substring(0, temp.lastIndexOf("</ns0:Envelope>")+15);
                        System.out.println("xml version"+searchedData);
                  }
            }
      }catch(Exception e){
            e.printStackTrace();
      }
}