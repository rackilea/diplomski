public static String createEncryptedButton(PrintWriter out) throws Exception {        
    String returnResult = "";        
    NVPEncoder encoder = new NVPEncoder();

    encoder.add("METHOD","BMCreateButton");

    encoder.add("BUTTONCODE","ENCRYPTED");
    encoder.add("BUTTONTYPE","CART");
    encoder.add("BUTTONSUBTYPE","PRODUCTS");        
    encoder.add("L_BUTTONVAR0","business="+businessEmail); //use your sandbox or paypal email
    encoder.add("L_BUTTONVAR1","item_name=Dress");
    encoder.add("L_BUTTONVAR2","item_number=100100");
    encoder.add("OPTION0NAME","Color and Size");
    encoder.add("L_OPTION0SELECT0","Pink Small");
    encoder.add("L_OPTION0PRICE0","6.00");
    encoder.add("L_OPTION0SELECT1","Pink Medium");
    encoder.add("L_OPTION0PRICE1","7.00");
    encoder.add("L_OPTION0SELECT2","Pink Large");
    encoder.add("L_OPTION0PRICE2","8.00");  

    String strNVPString = encoder.encode();
    String ppresponse = call(strNVPString,out);
    NVPDecoder results = new NVPDecoder();
    results.decode(ppresponse);                

    String buttonCode = results.get("WEBSITECODE");

     out.print("the code is :"+buttonCode);              

    return returnResult;
}

   public static String call(String payload, PrintWriter out) throws Exception {

//Remember to setup your API credentials, whether you're using Sandbox
//for testing or Paypal when you go live
String USER = "yourUsername"; //API Username
String PWD = "yourPassword"; //API Password
String SIGNATURE = "yourSignature"; //API Signature
String VERSION = "74.0"; //Version numbers differ from Paypal and Sandbox site. Do View > Source and look in source code for current version number under each site.

StringBuffer request = new StringBuffer();
request.append("USER="+USER+"&PWD="+PWD+"&SIGNATURE="+SIGNATURE+"&VERSION="+VERSION);
request.append("&");


//this is for Sandbox testing
//when you go live with paypal, switch it to
//https://api-3t.paypal.com/nvp 
URL url = new URL("https://api-3t.sandbox.paypal.com/nvp");

        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "text/namevalue");
        DataOutputStream outst = new DataOutputStream(connection.getOutputStream());        
        outst.write(request.toString().getBytes());
        outst.close();

        // Read the gateway response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    } // call