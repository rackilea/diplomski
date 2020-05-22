public static void main(String[] args) {
        String json = "{ \"emp_id\": 1017," 
               + "\"emp_name\": \"karthik Y\"," 
               + "\"emp_designation\": \"Manager\"," 
               + "\"department\": \"JavaJson\"," 
               + "\"salary\": 30000," 
               + "\"direct_reports\": [" 
               + "\"Nataraj G\","
               + "\"Kalyan\"," 
               + "\"Mahitha\"]}"; 

        HashMap<String, String> jsonStore = new HashMap<String, String>(); 
        jsonStore.put("myJson", json); 

        System.out.println(jsonStore.get("myJson"));
    }