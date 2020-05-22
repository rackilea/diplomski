/**
 * Example call:<br>
 * sendHTTPRequestAndSysoutData("http://www.google.com"); 
 * @param target
 */

public static void sendHTTPRequestAndSysoutData(String target){
    try{
        URL my_url = new URL(target);
        BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
        String strTemp = "";
        while (null != (strTemp = br.readLine())){
            System.out.println(strTemp);
        }
    }
    catch(IOException e){
        e.printStackTrace();
    }
}