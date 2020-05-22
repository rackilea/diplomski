public String countryInfo (CSVParser parser,String desiredCountry){
     FileResource fr = new FileResource();
     String exports= "";
    String countryName= "";
     String value= "";
    for (CSVRecord record : parser){
      exports=record.get("Exports");
      countryName=record.get("Country");
      value= record.get("Value");
      if (exports== null || !countryName.equals(desiredCountry)){
        String notf= "info has not been found";
        return notf;
      }
    }
    String info= countryName +":"+ exports;
    return info;
       }
public void tester (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser,"Germany");
       }