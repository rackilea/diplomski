public class myMain {

public static void main(String[] args) {

    JSONtoVar jsonToVar=new JSONtoVar();
    HashMap<String, String> mapJson=(HashMap<String, String>) jsonToVar.parseJson();

    System.out.println("mapJson TenderType "+mapJson.get("TenderType"));
    System.out.println("mapJson TenderAmount "+mapJson.get("TenderAmount"));
    System.out.println("mapJson CrdName "+mapJson.get("CrdName"));

   }

 }

 class JSONtoVar {

    public Map<String,String> parseJson(){

    HashMap<String, String> tender= new HashMap<String, String>();

    /*
        Get the value from JSON and set value.This has already be done          by you

    */

     tender.put("TenderType",TenderType)    ;
     tender.put("TenderAmount",TenderAmount);
     tender.put("CrdName",CrdName);


    return tender;



  }
}